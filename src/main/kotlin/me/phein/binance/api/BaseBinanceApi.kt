package me.phein.binance.api

import me.phein.binance.api.market.MarketBinanceApi

interface BaseBinanceApi {
    @Deprecated("Not implemented yet")
    fun wallet(): WalletBinanceApi = throw NotImplementedError()
    @Deprecated("Not implemented yet")
    fun subAccount(): SubAccountBinanceApi = throw NotImplementedError()
    fun market(): MarketBinanceApi
    @Deprecated("Not implemented yet")
    fun websocket(): WebSocketBinanceApi = throw NotImplementedError()

    // Not implemented
    interface WalletBinanceApi
    interface SubAccountBinanceApi
    interface WebSocketBinanceApi
}