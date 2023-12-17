package com.example.check24test.data.remote.network.response

import com.example.check24test.R
import com.example.check24test.data.remote.network.response.ErrorType.UnknownError

sealed class Check24Response<T>(
    var data: T? = null,
    var loading: Boolean? = false,
    var errorType: ErrorType? = null,
) {
    class Success<T>(data: T) : Check24Response<T>(data)
    class Loading<T>(loading: Boolean?) : Check24Response<T>(null, loading)
    class Error<T>(errorType: ErrorType = UnknownError) :
        Check24Response<T>(null, false, errorType)
}

enum class ErrorType(val errorMessageId: Int) {
    NetworkError(R.string.network_error),
    SocketTimeout(R.string.timeout_error),
    UnknownError(R.string.unknown_error),
}