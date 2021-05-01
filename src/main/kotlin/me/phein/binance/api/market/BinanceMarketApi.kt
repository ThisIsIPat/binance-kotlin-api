package me.phein.binance.api.market

interface BinanceMarketApi {
    /**
     * Test connectivity to the Rest API.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#test-connectivity">Binance API documentation</a>
     */
    suspend fun ping(): Unit

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#check-server-time">Binance API documentation</a>
     */
    suspend fun serverTime(): Long

    /**
     * Get the current exchange trading rules and symbol information.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#exchange-information">Binance API documentation</a>
     */
    suspend fun exchangeInfo(): ExchangeInfo

    /**
     * Get the current orders.
     *
     * @param limit Default [100][OrderBookLimit.ONE_HUNDRED]; max [5000][OrderBookLimit.FIVE_THOUSAND].
     * Valid limits: [[5][OrderBookLimit.FIVE],
     * [10][OrderBookLimit.TEN],
     * [20][OrderBookLimit.TWENTY],
     * [50][OrderBookLimit.FIFTY],
     * [100][OrderBookLimit.ONE_HUNDRED],
     * [500][OrderBookLimit.FIVE_HUNDRED],
     * [1000][OrderBookLimit.ONE_THOUSAND],
     * [5000][OrderBookLimit.FIVE_THOUSAND]]
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#order-book">Binance API documentation</a>
     */
    suspend fun orderBook(symbol: String, limit: OrderBookLimit = OrderBookLimit.ONE_HUNDRED): OrderBook

    /**
     * Get recent trades.
     *
     * ##### The Binance API always returns time-related data in ascending order: Oldest first, newest last.
     *
     * @param limit Default 500; max 1000.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list">Binance API documentation</a>
     */
    suspend fun trades(symbol: String, limit: Int = 500): List<Trade>

    /**
     * Get compressed, aggregate trades.
     * Trades that fill at the time, from the same order, with the same price will have the quantity aggregated.
     *
     * - If [startTime] and [endTime] are sent, the time between [startTime] and [endTime] must be less than 1 hour.
     * - If [fromId], [startTime] and [endTime] are not sent, the most recent aggregate trades will be returned.
     *
     * ##### The Binance API always returns time-related data in ascending order: Oldest first, newest last.
     *
     * @param startTime Timestamp in ms to get aggregate trades from INCLUSIVE.
     * @param endTime Timestamp in ms to get aggregate trades until INCLUSIVE.
     * @param fromId ID to get aggregate trades from INCLUSIVE.
     * @param limit Default 500; max 1000.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#compressed-aggregate-trades-list">Binance API documentation</a>
     */
    suspend fun aggTrades(symbol: String, startTime: Long? = null, endTime: Long? = null, fromId: Long? = null, limit: Int = 500): List<AggTrade>

    /**
     * Kline/candlestick bars for a symbol.
     * Klines are uniquely identified by their open time.
     *
     * - If [startTime] and [endTime] are not sent, the most recent klines will be returned.
     *
     * ##### The Binance API always returns time-related data in ascending order: Oldest first, newest last.
     *
     * @param startTime Timestamp in ms to get klines from INCLUSIVE.
     * @param endTime Timestamp in ms to get klines until INCLUSIVE.
     * @param limit Default 500; max 1000.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data">Binance API documentation</a>
     */
    suspend fun klines(symbol: String, interval: KlineInterval, startTime: Long? = null, endTime: Long? = null, limit: Int = 500): List<Kline>

    /**
     * Current average price for a symbol.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#current-average-price">Binance API documentation</a>
     */
    suspend fun avgPrice(symbol: String): AvgPrice

    /**
     * 24 hour rolling window price change statistics. **Careful** when accessing this with no symbol.
     * If the symbol is not sent, bookTickers for all symbols will be returned.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Binance API documentation</a>
     */
    suspend fun rolling24Ticker(symbol: String): Rolling24Ticker

    /**
     * 24 hour rolling window price change statistics. **Careful** when accessing this with no symbol.
     * If the symbol is not sent, bookTickers for all symbols will be returned.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Binance API documentation</a>
     */
    suspend fun rolling24Ticker(): List<Rolling24Ticker>

    /**
     * Latest price for a symbol or symbols.
     * If the symbol is not sent, prices for all symbols will be returned.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Binance API documentation</a>
     */
    suspend fun priceTicker(symbol: String): PriceTicker

    /**
     * Latest price for a symbol or symbols.
     * If the symbol is not sent, prices for all symbols will be returned.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Binance API documentation</a>
     */
    suspend fun priceTicker(): List<PriceTicker>

    /**
     * Best price/qty on the order book for a symbol or symbols.
     * If the symbol is not sent, bookTickers for all symbols will be returned.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Binance API documentation</a>
     */
    suspend fun bookTicker(symbol: String): BookTicker

    /**
     * Best price/qty on the order book for a symbol or symbols.
     * If the symbol is not sent, bookTickers for all symbols will be returned.
     *
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Binance API documentation</a>
     */
    suspend fun bookTicker(): List<BookTicker>
}