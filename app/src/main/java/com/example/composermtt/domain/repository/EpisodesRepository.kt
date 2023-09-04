package com.example.composermtt.domain.repository

import com.example.composermtt.domain.model.EpisodeDmn
import com.example.composermtt.mydata.utils.Result
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {

    suspend fun getEpisodes(page:Int): Flow<Result<List<EpisodeDmn>>>
}