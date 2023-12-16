package com.example.check24test.ui.main.domain.usecases

import com.example.check24test.data.remote.network.response.RealEstateAdvertisement
import com.example.check24test.ui.main.domain.repository.Check24Repository
import kotlinx.coroutines.flow.Flow

class GetRealEstateDetailsUseCase(private val repository: Check24Repository) {
    suspend fun build(realEstateId: Int): Flow<RealEstateAdvertisement> =
        repository.getRealEstateDetails(realEstateId)
}