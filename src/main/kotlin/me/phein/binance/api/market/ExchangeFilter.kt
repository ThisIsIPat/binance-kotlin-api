package me.phein.binance.api.market

/**
 * Filters define trading rules on a symbol or an exchange.
 * Filters come in two forms: [symbol filters][SymbolFilter] and [exchange filters][ExchangeFilter].
 *
 * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#filters">Binance API documentation</a>
 */
abstract class ExchangeFilter

data class ExchangeMaxNumOrdersFilter(val maxNumOrders: Long): ExchangeFilter()
data class ExchangeMaxAlgoOrdersFilter(val maxNumAlgoOrders: Long): ExchangeFilter()