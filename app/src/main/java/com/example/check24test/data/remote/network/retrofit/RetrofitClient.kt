package com.example.check24test.data.remote.network.retrofit

import com.google.gson.GsonBuilder
import com.squareup.leakcanary.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS

class RetrofitClient(
    private val baseURL: String,
    private val httpClient: OkHttpClient.Builder,
    private val httpLoggingInterceptor: HttpLoggingInterceptor,
    private val builder: Retrofit.Builder,
) {

    fun getInstance(): Retrofit {
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(httpLoggingInterceptor)
        }

        val gson = GsonBuilder()
            .setLenient()
            .create()

        builder.baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
        httpClient.readTimeout(timeout = 1000L, MILLISECONDS)
        httpClient.connectTimeout(timeout = 1000L, MILLISECONDS)
        httpClient.writeTimeout(timeout = 1000L, MILLISECONDS)
        builder.client(httpClient.build())
        return builder.build()
    }
}