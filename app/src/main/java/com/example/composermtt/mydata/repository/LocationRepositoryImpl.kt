package com.example.composermtt.mydata.repository

import com.example.composermtt.domain.model.LocationLocationDmn
import com.example.composermtt.domain.repository.LocationRepository
import com.example.composermtt.mydata.utils.Result
import com.example.composermtt.mydata.model.toListLocations
import com.example.composermtt.mydata.remote.RickAndMortyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor (
    private val rickAndMortyApi: RickAndMortyApi
            ):LocationRepository {
    override suspend fun getLocations(page: Int): Flow<Result<List<LocationLocationDmn>>>  = flow {
        emit(Result.Loading())
        try {
            val responce = rickAndMortyApi.getAllLocations(page).toListLocations()
            emit(Result.Success(responce))
        }
        catch (e: HttpException){
            emit(
                Result.Error(
                message = "went wrong",
                data = null
            ))
        }
        catch (e: IOException){
            emit(
                Result.Error(
                message = "Could not read server response,check your internet",
                data = null
            ))
        }
    }
}