package me.phein.binance.ktorqueue

import io.ktor.client.features.*
import io.ktor.client.statement.*

open class BinanceErrorException(httpResponse: HttpResponse, open val msg: String) :
    ResponseException(httpResponse, msg)
// TODO: More specific error codes? https://github.com/binance/binance-spot-api-docs/blob/master/errors.md
class BinanceCodeErrorException(httpResponse: HttpResponse, val code: Int, msg: String) :
    BinanceErrorException(httpResponse, msg)
class BinanceSuccessErrorException(httpResponse: HttpResponse, val success: Boolean, msg: String) :
    BinanceErrorException(httpResponse, msg)

data class BinanceCodeError(val code: Int, val msg: String) {
    fun asHttpException(httpResponse: HttpResponse) = BinanceCodeErrorException(httpResponse, code, msg)
}
data class BinanceSuccessError(val success: Boolean, val msg: String) {
    fun asHttpException(httpResponse: HttpResponse) = BinanceSuccessErrorException(httpResponse, success, msg)
}

class OutdatedApiEndpointException(httpResponse: HttpResponse) :
    BinanceErrorException(httpResponse, "The requested API endpoint ${httpResponse.request.url} does not exist")