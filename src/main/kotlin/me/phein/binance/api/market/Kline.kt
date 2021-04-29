package me.phein.binance.api.market

import java.math.BigDecimal

data class Kline(
    val time: Long,
    val closeTime: Long,
    val open: BigDecimal,
    val high: BigDecimal,
    val low: BigDecimal,
    val close: BigDecimal,
    val volume: Volume,
    val numTrades: Long,
) {
    data class Volume(
        val totalBaseVolume: BigDecimal,
        val totalQuoteVolume: BigDecimal,
        val takerBaseVolume: BigDecimal,
        val takerQuoteVolume: BigDecimal
    ) {
        val makerBaseVolume: BigDecimal by lazy { totalBaseVolume - takerBaseVolume }
        val makerQuoteVolume: BigDecimal by lazy { totalQuoteVolume - takerQuoteVolume }
    }
}