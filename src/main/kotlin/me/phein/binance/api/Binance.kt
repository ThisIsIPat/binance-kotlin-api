package me.phein.binance.api

class Binance {
    companion object {
        fun api(): BaseBinanceApi = throw NotImplementedError()
    }
}