package com.example.composermtt.domain.repository

import com.example.composermtt.domain.model.LocationLocationDmn
import com.example.composermtt.mydata.utils.Result
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun getLocations(page:Int): Flow<Result<List<LocationLocationDmn>>>
}