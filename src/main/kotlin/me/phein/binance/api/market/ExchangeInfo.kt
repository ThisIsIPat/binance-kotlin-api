package me.phein.binance.api.market

data class ExchangeInfo(
    val timezone: String,    // Type specifiable?
    val serverTime: Long,
    val rateLimits: Set<RateLimit>,
    val exchangeFilters: Set<ExchangeFilter>,
    val symbols: Set<Symbol>
)
