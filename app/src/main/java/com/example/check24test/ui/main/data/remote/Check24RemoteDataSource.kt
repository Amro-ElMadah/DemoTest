package com.example.check24test.ui.main.data.remote

import com.example.check24test.data.remote.network.response.RealEstateAdvertisement
import com.example.check24test.data.remote.network.response.RealEstateAdvertisementsResponse
import com.example.check24test.data.remote.network.retrofit.Check24Api

class Check24RemoteDataSource(private val realEstateAdvertisementsAPI: Check24Api) {

    suspend fun getRealEstateAdvertisements(): RealEstateAdvertisementsResponse =
        realEstateAdvertisementsAPI.loadRealEstateAdvertisements()

    suspend fun getRealEstateDetails(realEstateId: Int): RealEstateAdvertisement =
        realEstateAdvertisementsAPI.getRealEstateDetails(realEstateId)
}