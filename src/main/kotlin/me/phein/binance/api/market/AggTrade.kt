package me.phein.binance.api.market

import kotlinx.serialization.SerialName
import java.math.BigDecimal

data class AggTrade(
    @SerialName("a")
    val id: Long,
    @SerialName("p")
    val price: BigDecimal,
    @SerialName("q")
    val quantity: BigDecimal,
    @SerialName("f")
    val firstTradeId: Long,
    @SerialName("l")
    val lastTradeId: Long,
    @SerialName("T")
    val time: Long,
    @SerialName("m")
    val isBuyerMaker: Boolean,
    @SerialName("M")
    val isBestMatch: Boolean
)
