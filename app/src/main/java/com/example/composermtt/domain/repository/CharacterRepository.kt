package com.example.composermtt.domain.repository

import com.example.composermtt.domain.model.CharacterDmn
import com.example.composermtt.domain.model.CharactersDmn
import com.example.composermtt.mydata.utils.Result
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(page:Int): Flow<Result<List<CharactersDmn>>>

   suspend fun getCharacter(id:Int): Result<CharacterDmn>

}