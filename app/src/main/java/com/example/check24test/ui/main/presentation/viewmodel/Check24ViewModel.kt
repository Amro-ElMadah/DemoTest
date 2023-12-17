package com.example.check24test.ui.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24test.data.remote.network.response.Check24Response
import com.example.check24test.data.remote.network.response.RealEstateAdvertisement
import com.example.check24test.data.remote.network.retrofit.getErrorType
import com.example.check24test.ui.main.domain.usecases.GetRealEstateDetailsUseCase
import com.example.check24test.ui.main.domain.usecases.GetRealEstatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Check24ViewModel @Inject constructor(
    private val getRealEstatesUseCase: GetRealEstatesUseCase,
    private val getRealEstateDetailsUseCase: GetRealEstateDetailsUseCase,
) : ViewModel() {
    private val _realEstates =
        MutableStateFlow<Check24Response<List<RealEstateAdvertisement>?>>(Check24Response.Loading(true))
    val realEstates get() = _realEstates.asStateFlow()

    private val _details = MutableStateFlow<Check24Response<RealEstateAdvertisement>>(Check24Response.Loading(false))
    val details get() = _details.asStateFlow()

    fun loadRealEstates() {
        viewModelScope.launch {
            getRealEstatesUseCase.build()
                .onStart {
                    _realEstates.emit(Check24Response.Loading(true))
                }
                .catch {
                    _realEstates.emit(Check24Response.Error(it.getErrorType()))
                }
                .collect {
                    _realEstates.emit(Check24Response.Success(it.items))
                }
        }
    }

    fun loadRealEstateDetails(realEstateId: Int) {
        viewModelScope.launch {
            getRealEstateDetailsUseCase.build(realEstateId)
                .onStart {
                    _details.emit(Check24Response.Loading(true))
                }
                .catch {
                    _details.emit(Check24Response.Error(it.getErrorType()))
                }
                .collect {
                    _details.emit(Check24Response.Success(it))
                }
        }
    }
}