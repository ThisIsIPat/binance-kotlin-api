package me.phein.binance.api.market

data class Symbol(
    val symbol: String,      // MAYBE custom type with available enums? Probably not worth it to maintain
    val status: SymbolStatus,
    val baseAsset: String,
    val baseAssetPrecision: Int,
    val quoteAsset: String,
    val quotePrecision: Int,
    val quoteAssetPrecision: Int,
    val orderTypes: Set<OrderType>,
    val icebergAllowed: Boolean,
    val ocoAllowed: Boolean,
    val isSpotTradingAllowed: Boolean,
    val isMarginTradingAllowed: Boolean,
    val filters: Set<SymbolFilter>,
    val permissions: Set<SymbolPermission>
)
