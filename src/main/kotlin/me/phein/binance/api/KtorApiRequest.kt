package me.phein.binance.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*

class KtorApiRequest(weight: Int, priority: Int = 0) : ApiRequest(weight, priority) {
    companion object {
        val apiEndpoints = listOf(
            "api.binance.com",
            "api1.binance.com",
            "api2.binance.com",
            "api3.binance.com"
        ).map { "https://$it/api/" }.toMutableList()

        val client: HttpClient by lazy {
            HttpClient(CIO) {
                // TODO: Set up kotlin serialization as Decoder
            }
        }
    }

    override suspend fun execute() {

    }
}