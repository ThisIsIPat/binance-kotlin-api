package me.phein.binance.ktorqueue.market

import io.ktor.client.*
import io.ktor.client.request.*
import me.phein.binance.ktorqueue.ApiRequest
import me.phein.binance.ktorqueue.KtorQueueBinanceApi

// TODO: Abstract http response code handling according to https://binance-docs.github.io/apidocs/spot/en/#general-api-information
class PingRequest(priority: Int = 0) : ApiRequest<Unit>(1, priority) {
    override suspend fun execute(client: HttpClient) = KtorQueueBinanceApi.binanceRequest<Unit>("v3/ping")
}