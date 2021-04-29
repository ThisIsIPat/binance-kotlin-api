package me.phein.binance.api.market

/**
 * The Binance API uses [atMost] by default.
 */
enum class OrderBookLimit(val value: Int) {
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    ONE_HUNDRED(100),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1_000),
    FIVE_THOUSAND(5_000);

    fun atLeast(amount: Int): OrderBookLimit? = values()
        .sortedBy { it.value }
        .firstOrNull { amount <= it.value }

    fun atMost(amount: Int): OrderBookLimit? = values()
        .sortedByDescending { it.value }
        .firstOrNull { amount >= it.value }
}