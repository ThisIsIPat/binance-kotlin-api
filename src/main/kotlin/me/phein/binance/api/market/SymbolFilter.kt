package me.phein.binance.api.market

import kotlinx.serialization.SerialName
import java.math.BigDecimal

/**
 * Filters define trading rules on a symbol or an exchange.
 * Filters come in two forms: [symbol filters][SymbolFilter] and [exchange filters][ExchangeFilter].
 *
 * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#filters">Binance API documentation</a>
 */
abstract class SymbolFilter

/**
 * The [`PRICE_FILTER`][SymbolPriceFilter] defines the `price` rules for a symbol.
 *
 * Any of the variables can be set to 0, which disables that rule in the `price filter`.
 * In order to pass the `price filter`, the following must be true for `price`/`stopPrice` of the enabled rules:
 *
 * - `price` >= [minPrice]
 * - `price` <= [maxPrice]
 * - (`price`-[minPrice]) % [tickSize] == 0
 *
 * @param minPrice defines the minimum `price`/`stopPrice` allowed;
 *  disabled if `minPrice` is null.
 * @param maxPrice defines the maximum `price`/`stopPrice` allowed;
 *  disabled if `maxPrice` is null.
 * @param tickSize defines the intervals that a `price`/`stopPrice` can be increased/decreased by;
 *  disabled if `tickSize` is null.
 */
// TODO: original documentation sends minPrice, maxPrice, tickSize 0 instead of null.
data class SymbolPriceFilter(val minPrice: BigDecimal?, val maxPrice: BigDecimal?, val tickSize: BigDecimal?)

/**
 * The [`PERCENT_PRICE`][SymbolPercentPriceFilter] filter defines valid range for a price based on the average of the previous trades.
 *
 * In order to pass the `percent price`, the following must be true for `price`:
 *
 * - `price` <= `weightedAveragePrice` * [multiplierUp]
 * - `price` >= `weightedAveragePrice` * [multiplierDown]
 *
 * @param multiplierUp TODO
 * @param multiplierDown TODO
 * @param avgPriceMins is the number of minutes the average price is calculated over. 0 means the last price is used.
 */
data class SymbolPercentPriceFilter(val multiplierUp: BigDecimal, val multiplierDown: BigDecimal, val avgPriceMins: Int)

/**
 * The [`LOT_SIZE`][LotSizeFilter] filter defines the `quantity` (aka "**lots**" in auction terms) rules for a symbol.
 *
 * In order to pass the `lot size`, the following must be true for `quantity`/`icebergQty`:
 *
 * - `quantity` >= [minQuantity]
 * - `quantity` <= [maxQuantity]
 * - (`quantity`-[minQuantity]) % [stepSize] == 0
 *
 * @param minQuantity defines the minimum `quantity`/`icebergQty` allowed.
 * @param maxQuantity defines the maximum `quantity`/`icebergQty` allowed.
 * @param stepSize defines the intervals that a `quantity`/`icebergQty` can be increased/decreased by.
 */
data class LotSizeFilter(
    @SerialName("minQty")
    val minQuantity: BigDecimal,
    @SerialName("maxQty")
    val maxQuantity: BigDecimal,
    val stepSize: BigDecimal)

// TODO: Documentation https://binance-docs.github.io/apidocs/spot/en/#filters

data class MinNotionalFilter(val minNotional: BigDecimal, val applyToMarket: Boolean, val avgPriceMins: Int)
data class IcebergPartsFilter(val limit: Int)
data class MarketLotSizeFilter(
    @SerialName("minQty")
    val minQuantity: BigDecimal,
    @SerialName("maxQty")
    val maxQuantity: BigDecimal,
    val stepSize: BigDecimal)
data class MaxNumOrdersFilter(val maxNumOrders: Int)
data class MaxNumAlgoOrdersFilter(val maxNumAlgoOrders: Int)
data class MaxNumIcebergOrdersFilter(val maxNumIcebergOrders: Int)
data class MaxPositionFilter(val maxPosition: BigDecimal)