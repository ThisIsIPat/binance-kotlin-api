package me.phein.binance.api.market

interface AuthMarketBinanceApi : MarketBinanceApi {
    /**
     * Get older market trades.
     *
     * @param limit Default 500; max 1000.
     * @param fromId Trade id to fetch from. Default gets most recent trades.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#old-trade-lookup">Binance API documentation</a>
     */
    suspend fun historicalTrades(symbol: String, limit: Int = 500, fromId: Long? = null): List<Trade>
}