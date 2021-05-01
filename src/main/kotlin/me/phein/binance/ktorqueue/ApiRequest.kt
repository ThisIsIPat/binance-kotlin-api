package me.phein.binance.ktorqueue

import io.ktor.client.*

abstract class ApiRequest<R>(val weight: Int, val priority: Int = 0) {
    abstract suspend fun execute(client: HttpClient): Any
}