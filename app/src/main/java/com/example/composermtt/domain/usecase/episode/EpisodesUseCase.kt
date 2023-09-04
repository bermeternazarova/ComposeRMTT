package com.example.composermtt.domain.usecase.episode

import com.example.composermtt.domain.model.EpisodeDmn
import com.example.composermtt.domain.repository.EpisodesRepository
import com.example.composermtt.mydata.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodesUseCase @Inject constructor(
    private val episodesRepository: EpisodesRepository
) {
    suspend operator fun invoke(page:Int): Flow<Result<List<EpisodeDmn>>> {
        return episodesRepository.getEpisodes(page)
    }
}