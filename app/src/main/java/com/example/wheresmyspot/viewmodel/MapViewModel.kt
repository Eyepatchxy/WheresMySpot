package com.example.wheresmyspot.viewmodel

import android.Manifest
import android.location.Location
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheresmyspot.data.dataclasses.response.DestinationCoordinatesResponse
import com.example.wheresmyspot.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationRepository: LocationRepository
): ViewModel() {

    private val _userLocation = mutableStateOf<Location?>(null)
    val userLocation: State<Location?> = _userLocation

    private val _parkingSpots = MutableStateFlow<DestinationCoordinatesResponse?>(null)
    val parkingSpots: StateFlow<DestinationCoordinatesResponse?> = _parkingSpots


    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun fetchUserLocation() {

        if (locationRepository.initialUserLocation != null) {
            _userLocation.value = locationRepository.initialUserLocation
        } else {
            viewModelScope.launch {
                _userLocation.value = locationRepository.getCurrentLocation()
            }
        }
    }


    fun fetchDestinationCoordinates(
        query: String
    ): DestinationCoordinatesResponse {
        TODO()
    }
}