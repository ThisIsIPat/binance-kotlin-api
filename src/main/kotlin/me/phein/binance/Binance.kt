package me.phein.binance

import me.phein.binance.api.BinanceApi
import me.phein.binance.ktorqueue.KtorQueueBinanceApi


/**
 * API wrapper for Binance.
 *
 * I'm in no way related to Binance. Use this API on your own responsibility.
 *
 * @author Patrick "IPat" Hein
 */
class Binance {
    companion object {
        fun api(): BinanceApi = KtorQueueBinanceApi()
    }
}