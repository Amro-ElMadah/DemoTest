package com.example.check24test.data.remote.network.retrofit

import com.example.check24test.data.remote.network.response.ErrorType
import com.example.check24test.data.remote.network.response.ErrorType.NetworkError
import com.example.check24test.data.remote.network.response.ErrorType.SocketTimeout
import com.example.check24test.data.remote.network.response.ErrorType.UnknownError
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.getErrorType(): ErrorType {
    return when (this) {
        is UnknownHostException -> NetworkError
        is SocketTimeoutException -> SocketTimeout
        else -> UnknownError
    }
}