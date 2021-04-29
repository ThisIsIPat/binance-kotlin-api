package me.phein.binance.api.market

enum class RateLimitInterval(val ms: Long) {
    SECOND(1_000),
    MINUTE(60_000),
    // HOUR(3_600_000),     Don't know why I wrote this - Gonna have to recheck
    DAY(86_400_000)
}