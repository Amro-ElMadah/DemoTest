package com.example.check24test.ui.main.domain.repository

import com.example.check24test.data.remote.network.response.RealEstateAdvertisement
import com.example.check24test.data.remote.network.response.RealEstateAdvertisementsResponse
import com.example.check24test.ui.main.data.remote.Check24RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Check24RepositoryImp(
    private val remoteDataSource: Check24RemoteDataSource,
) : Check24Repository {
    override suspend fun getRealEstatesAdvertisements(): Flow<RealEstateAdvertisementsResponse> =
        flow {
            emit(remoteDataSource.getRealEstateAdvertisements())
        }.flowOn(Dispatchers.IO)

    override suspend fun getRealEstateDetails(realEstateId: Int): Flow<RealEstateAdvertisement> =
        flow {
            emit(remoteDataSource.getRealEstateDetails(realEstateId = realEstateId))
        }.flowOn(Dispatchers.IO)
}