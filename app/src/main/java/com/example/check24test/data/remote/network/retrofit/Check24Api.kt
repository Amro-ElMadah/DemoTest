package com.example.check24test.data.remote.network.retrofit

import com.example.check24test.data.remote.network.response.RealEstateAdvertisement
import com.example.check24test.data.remote.network.response.RealEstateAdvertisementsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Check24Api {

    @GET("listings.json")
    suspend fun loadRealEstateAdvertisements(): RealEstateAdvertisementsResponse

    @GET("listings/{listingId}.json")
    suspend fun getRealEstateDetails(@Path("listingId") listingId: Int): RealEstateAdvertisement

}