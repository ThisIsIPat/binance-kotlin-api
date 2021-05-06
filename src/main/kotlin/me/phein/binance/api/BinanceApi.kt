package me.phein.binance.api

import me.phein.binance.api.market.BinanceMarketApi

interface BinanceApi {
    @Deprecated("Not implemented yet")
    fun wallet(): BinanceWalletApi = throw NotImplementedError()
    @Deprecated("Not implemented yet")
    fun subAccount(): BinanceSubAccountApi = throw NotImplementedError()
    fun market(): BinanceMarketApi
    @Deprecated("Not implemented yet")
    fun websocket(): BinanceWebsocketApi = throw NotImplementedError()

    // Not implemented
    interface BinanceWalletApi
    interface BinanceSubAccountApi
    interface BinanceWebsocketApi

    // TODO (important) https://github.com/binance/binance-spot-api-docs/blob/master/errors.md

    companion object {
        val endpoints = listOf(
            "api.binance.com",
            "api1.binance.com",
            "api2.binance.com",
            "api3.binance.com"
        ).map { "https://$it/api" }
    }
}