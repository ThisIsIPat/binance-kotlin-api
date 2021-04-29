package me.phein.binance.api.market

import kotlinx.serialization.SerialName
import java.math.BigDecimal

data class Trade(
    val id: Long,
    val price: BigDecimal,
    @SerialName("qty")
    val quantity: BigDecimal,
    @SerialName("quoteQty")
    val quoteQuantity: BigDecimal,
    val time: Long,
    val isBuyerMaker: Boolean,
    val isBestMatch: Boolean
)
