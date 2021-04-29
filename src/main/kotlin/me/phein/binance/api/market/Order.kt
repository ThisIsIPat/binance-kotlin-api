package me.phein.binance.api.market

import java.math.BigDecimal

data class Order(val price: BigDecimal, val quantity: BigDecimal)
