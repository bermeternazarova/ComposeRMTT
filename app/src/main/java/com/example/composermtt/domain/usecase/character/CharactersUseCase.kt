package com.example.composermtt.domain.usecase.character

import com.example.composermtt.domain.model.CharactersDmn
import com.example.composermtt.domain.repository.CharacterRepository
import com.example.composermtt.mydata.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
     suspend operator fun invoke(page:Int):Flow<Result<List<CharactersDmn>>>{
        return characterRepository.getCharacters(page)
    }
}