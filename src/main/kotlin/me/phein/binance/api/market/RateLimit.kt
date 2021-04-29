package me.phein.binance.api.market

data class RateLimit(
    val rateLimitType: RateLimitType,
    val interval: RateLimitInterval,
    val intervalNum: Int,
    val limit: Long
)
