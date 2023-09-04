package com.example.composermtt.domain.usecase.character

import com.example.composermtt.domain.model.CharacterDmn
import com.example.composermtt.domain.repository.CharacterRepository
import com.example.composermtt.mydata.utils.Result
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
   private val characterRepository: CharacterRepository
   ) {
suspend operator fun  invoke(id:Int): Result<CharacterDmn> {
   return characterRepository.getCharacter(id)
}
}