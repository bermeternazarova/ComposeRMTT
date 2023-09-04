package com.example.composermtt.mydata.repository

import com.example.composermtt.domain.model.CharacterDmn
import com.example.composermtt.domain.model.CharactersDmn
import com.example.composermtt.domain.repository.CharacterRepository
import com.example.composermtt.mydata.utils.Result
import com.example.composermtt.mydata.model.character.toCharacter
import com.example.composermtt.mydata.model.toListCharactersModel
import com.example.composermtt.mydata.remote.RickAndMortyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
   private val rickAndMortyApi: RickAndMortyApi
):CharacterRepository{

    override suspend fun getCharacters(page: Int): Flow<Result<List<CharactersDmn>>> = flow {
        emit(Result.Loading())
        try {
            val responce = rickAndMortyApi.getAllCharacters(page).toListCharactersModel()
            emit(Result.Success(responce))
        }
        catch (e:HttpException){
            emit(
                Result.Error(
                message = "went wrong",
                data = null
            ))
        }
        catch (e:IOException){
            emit(
                Result.Error(
                message = "Could not read server response,check your internet",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<CharacterDmn> {
        val responce2 = try {
            rickAndMortyApi.getCharacter(id)
        }
        catch (e:Exception){
           return Result.Error(
               "Unknown error"
           )
        }
        return Result.Success(responce2.toCharacter())
    }
}