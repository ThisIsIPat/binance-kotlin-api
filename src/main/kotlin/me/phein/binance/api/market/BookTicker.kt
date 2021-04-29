package me.phein.binance.api.market

import kotlinx.serialization.SerialName
import java.math.BigDecimal

data class BookTicker(
    val symbol: String,
    val bidPrice: BigDecimal,
    @SerialName("bidQty")
    val bidQuantity: BigDecimal,
    val askPrice: BigDecimal,
    @SerialName("askQty")
    val askQuantity: BigDecimal,
)
