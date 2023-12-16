package com.example.check24test.ui.main.injection

import com.example.check24test.data.remote.network.retrofit.Check24Api
import com.example.check24test.ui.main.data.remote.Check24RemoteDataSource
import com.example.check24test.ui.main.domain.repository.Check24Repository
import com.example.check24test.ui.main.domain.repository.Check24RepositoryImp
import com.example.check24test.ui.main.domain.usecases.GetRealEstateDetailsUseCase
import com.example.check24test.ui.main.domain.usecases.GetRealEstatesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
open class RealEstatesModule {

    @Provides
    fun provideCheck24RemoteDataSource(realEstateAdvertisementsAPI: Check24Api) =
        Check24RemoteDataSource(realEstateAdvertisementsAPI = realEstateAdvertisementsAPI)

    @Provides
    fun provideCheck24Repository(
        remoteDataSource: Check24RemoteDataSource,
    ): Check24Repository =
        Check24RepositoryImp(remoteDataSource)

    @Provides
    fun provideGetRealEstatesUseCase(repository: Check24Repository) =
        GetRealEstatesUseCase(repository)

    @Provides
    fun provideGetRealEstateDetailsUseCase(repository: Check24Repository) =
        GetRealEstateDetailsUseCase(repository)
}