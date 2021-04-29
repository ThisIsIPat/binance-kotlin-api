package me.phein.binance.api.market

data class OrderBook(
    val lastUpdateId: Long,
    val bids: List<Order>,
    val asks: List<Order>
)
