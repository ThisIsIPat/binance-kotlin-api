package me.phein.binance.api

abstract class ApiRequest(val weight: Int, val priority: Int = 0) {
    abstract suspend fun execute()
}