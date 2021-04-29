package me.phein.binance.api.market

import java.math.BigDecimal

data class PriceTicker(
    val symbol: String,
    val price: BigDecimal
)
