package me.phein.binance.api.market

import kotlinx.serialization.SerialName
import java.math.BigDecimal

data class Rolling24Ticker(
    val symbol: String,
    val priceChange: BigDecimal,
    val priceChangePercent: BigDecimal,
    val weightedAvgPrice: AvgPrice,     // Always parse weighted avg price to 24h = 1440m
    val prevClosePrice: BigDecimal,
    val lastPrice: BigDecimal,
    @SerialName("lastQty")
    val lastQuantity: BigDecimal,
    val bidPrice: BigDecimal,
    val askPrice: BigDecimal,
    val openPrice: BigDecimal,
    val highPrice: BigDecimal,
    val lowPrice: BigDecimal,
    @SerialName("volume")
    val totalBaseVolume: BigDecimal,
    @SerialName("quoteVolume")
    val totalQuoteVolume: BigDecimal,
    val openTime: Long,
    val closeTime: Long,
    val firstId: Long,
    val lastId: Long,
    @SerialName("count")
    val numTrades: Long,
)
