package me.phein.binance.ktorqueue.market

import io.ktor.client.*
import io.ktor.client.request.*
import me.phein.binance.ktorqueue.ApiRequest

// TODO: Abstract http response code handling according to https://binance-docs.github.io/apidocs/spot/en/#general-api-information
class PingRequest(priority: Int = 0) : ApiRequest<Unit>(1, priority) {
    override suspend fun execute(client: HttpClient) = client.get<Unit>("v3/ping")
}