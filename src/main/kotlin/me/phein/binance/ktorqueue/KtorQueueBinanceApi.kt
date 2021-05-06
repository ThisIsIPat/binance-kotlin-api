package me.phein.binance.ktorqueue

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.channels.Channel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import me.phein.binance.api.BinanceApi
import me.phein.binance.ktorqueue.market.KtorQueueBinanceMarketApi
import java.util.*
import java.util.concurrent.PriorityBlockingQueue

class KtorQueueBinanceApi : BinanceApi {
    private val requestQueue: PriorityBlockingQueue<Pair<ApiRequest<*>, Channel<*>>> = PriorityBlockingQueue(11,
        Comparator.comparingInt<Pair<ApiRequest<*>, Channel<*>>> { it.first.priority }.reversed()
    )

    override fun market() = KtorQueueBinanceMarketApi(this)

    // Note that the visibility modifier is an aware decision
    //  If someone wants to send a custom request, it should be quick and easy without having to fork the repo.
    //  (Though, if you are more up-to-date with an API endpoint, I would love a pull request :) )
    suspend fun <R> queueRequest(request: ApiRequest<R>): R {
        // TODO: Think about how to use [BinanceResponse]
        return Channel<R>(Channel.RENDEZVOUS).also { responseChannel ->
            requestQueue.add(request to responseChannel)
        }.receive()
    }

    companion object {
        val client: HttpClient by lazy {
            HttpClient(CIO) {
                // TODO: Set up kotlin serialization as Decoder (Default?)
                HttpResponseValidator {
                    validateResponse { response ->
                        when (response.status.value) {
                            404 -> throw OutdatedApiEndpointException(response)
                        }
                    }
                }
            }
        }

        @Throws(BinanceErrorException::class)
        suspend inline fun <reified R> binanceRequest(
            subUrl: String,
            httpRequestConfig: HttpRequestBuilder.() -> Unit = {}
        ): R {
            // TODO: Load balancer (Live benchmarker) API endpoints https://binance-docs.github.io/apidocs/spot/en/#general-info
            // Load balancer is required to be extremely high-performant
            val baseUrl = BinanceApi.endpoints.random()

            val response = client.request<HttpResponse> {
                url { urlBuilder ->
                    urlBuilder.path(baseUrl, subUrl)
                }
                apply(httpRequestConfig)
            }

            if (response.status.value in (200..299)) return response.receive()

            val errorPayload = response.receive<String>()
            throw when {
                errorPayload.contains("\"success\":") -> {
                    Json.decodeFromString<BinanceSuccessError>(errorPayload).asHttpException(response)
                }
                errorPayload.contains("\"code\":") -> {
                    Json.decodeFromString<BinanceCodeError>(errorPayload).asHttpException(response)
                }
                else -> {
                    BinanceErrorException(response, "Unknown error payload: $errorPayload")
                }
            }
        }
    }
}