package com.example.check24test.data.remote.network.response

sealed class Check24Response<T>(
    var data: T? = null,
    var loading: Boolean? = false,
    var throwable: Throwable? = null,
) {
    class Success<T>(data: T) : Check24Response<T>(data)
    class Loading<T>(loading: Boolean?) : Check24Response<T>(null, loading)
    class Error<T>(throwable: Throwable?) :
        Check24Response<T>(null, false, throwable)
}