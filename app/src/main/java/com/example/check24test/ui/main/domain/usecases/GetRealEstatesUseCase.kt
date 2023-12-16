package com.example.check24test.ui.main.domain.usecases

import com.example.check24test.data.remote.network.response.RealEstateAdvertisementsResponse
import com.example.check24test.ui.main.domain.repository.Check24Repository
import kotlinx.coroutines.flow.Flow

class GetRealEstatesUseCase(private val repository: Check24Repository) {
    suspend fun build(): Flow<RealEstateAdvertisementsResponse> =
        repository.getRealEstatesAdvertisements()
}