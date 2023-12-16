package com.example.check24test.ui.main.domain.repository

import com.example.check24test.data.remote.network.response.RealEstateAdvertisement
import com.example.check24test.data.remote.network.response.RealEstateAdvertisementsResponse
import kotlinx.coroutines.flow.Flow

interface Check24Repository {
    suspend fun getRealEstatesAdvertisements(): Flow<RealEstateAdvertisementsResponse>

    suspend fun getRealEstateDetails(realEstateId: Int): Flow<RealEstateAdvertisement>
}