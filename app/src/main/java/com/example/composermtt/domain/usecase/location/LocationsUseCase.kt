package com.example.composermtt.domain.usecase.location

import com.example.composermtt.domain.model.LocationLocationDmn
import com.example.composermtt.domain.repository.LocationRepository
import com.example.composermtt.mydata.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationsUseCase @Inject constructor (
    private val locationRepository: LocationRepository
        ){
    suspend operator fun invoke(page:Int): Flow<Result<List<LocationLocationDmn>>> {
        return locationRepository.getLocations(page)
    }
}