package me.phein.binance.api.market

import kotlinx.serialization.SerialName
import java.math.BigDecimal

data class AvgPrice(
    @SerialName("mins")
    val minutes: Int,
    val price: BigDecimal
)