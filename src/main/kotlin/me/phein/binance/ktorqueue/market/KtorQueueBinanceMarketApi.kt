package me.phein.binance.ktorqueue.market

import me.phein.binance.api.market.*
import me.phein.binance.ktorqueue.KtorQueueBinanceApi

open class KtorQueueBinanceMarketApi(private val base: KtorQueueBinanceApi) : PriorityAuthBinanceMarketApi {
    override suspend fun ping(priority: Int) = base.queueRequest(PingRequest(priority))
    override suspend fun serverTime(priority: Int) = TODO()

    override suspend fun exchangeInfo(priority: Int): ExchangeInfo {
        TODO("Not yet implemented")
    }

    override suspend fun orderBook(symbol: String, limit: OrderBookLimit, priority: Int): OrderBook {
        TODO("Not yet implemented")
    }

    override suspend fun trades(symbol: String, limit: Int, priority: Int): List<Trade> {
        TODO("Not yet implemented")
    }

    override suspend fun historicalTrades(symbol: String, limit: Int, fromId: Long?, priority: Int): List<Trade> {
        TODO("Not yet implemented")
    }

    override suspend fun aggTrades(
        symbol: String,
        startTime: Long?,
        endTime: Long?,
        fromId: Long?,
        limit: Int,
        priority: Int
    ): List<AggTrade> {
        TODO("Not yet implemented")
    }

    override suspend fun klines(
        symbol: String,
        interval: KlineInterval,
        startTime: Long?,
        endTime: Long?,
        limit: Int,
        priority: Int
    ): List<Kline> {
        TODO("Not yet implemented")
    }

    override suspend fun avgPrice(symbol: String, priority: Int): AvgPrice {
        TODO("Not yet implemented")
    }

    override suspend fun rolling24Ticker(symbol: String, priority: Int): Rolling24Ticker {
        TODO("Not yet implemented")
    }

    override suspend fun rolling24Ticker(priority: Int): List<Rolling24Ticker> {
        TODO("Not yet implemented")
    }

    override suspend fun priceTicker(symbol: String, priority: Int): PriceTicker {
        TODO("Not yet implemented")
    }

    override suspend fun priceTicker(priority: Int): List<PriceTicker> {
        TODO("Not yet implemented")
    }

    override suspend fun bookTicker(symbol: String, priority: Int): BookTicker {
        TODO("Not yet implemented")
    }

    override suspend fun bookTicker(priority: Int): List<BookTicker> {
        TODO("Not yet implemented")
    }
}