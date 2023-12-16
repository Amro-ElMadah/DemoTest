package com.example.check24test.modules

import com.example.check24test.data.remote.network.retrofit.Check24Api
import com.example.check24test.data.remote.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class NetworkModule(private val baseURL: String = "") {

    object DAGGER_CONSTANTS {
        const val BASE_URL = "baseUrlString"
    }

    private object ApiEndpointsConstants {
        const val ProductionURL = "https://gsl-apps-technical-test.dignp.com/"
    }

    @Provides
    @Singleton
    @Named(value = DAGGER_CONSTANTS.BASE_URL)
    fun providesBaseUrl() =
        when {
            baseURL.isNotEmpty() -> baseURL
            else -> ApiEndpointsConstants.ProductionURL
        }

    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()

    @Provides
    @Singleton
    fun provideRetrofitClient(
        @Named(DAGGER_CONSTANTS.BASE_URL) baseURL: String,
        httpClient: OkHttpClient,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        builder: Retrofit.Builder,
    )
        : Retrofit = RetrofitClient(
        baseURL = baseURL,
        httpClient = httpClient.newBuilder(),
        httpLoggingInterceptor = httpLoggingInterceptor,
        builder = builder
    ).getInstance()

    @Provides
    @Singleton
    fun provideCheck24Api(retrofit: Retrofit)
        : Check24Api = retrofit.create(Check24Api::class.java)
}