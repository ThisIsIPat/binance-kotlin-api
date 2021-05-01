package me.phein.binance.ktorqueue

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlinx.coroutines.channels.Channel
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
                // TODO: Set up kotlin serialization as Decoder
            }
        }
    }
}