package com.example.composermtt.mydata.model

import com.example.composermtt.domain.model.EpisodeDmn
import com.example.composermtt.mydata.model.character.InfoModel

data class EpisodesModel(
    val info: InfoModel,
    val results: List<EpisodeModel>
)
fun EpisodesModel.toListEpisodes(): List<EpisodeDmn>{
    val map = results.mapIndexed { index, resul ->
        EpisodeDmn(
          air_date = resul.air_date,
            characters = resul.characters,
            created = resul.created,
            episode = resul.episode,
            id = resul.id,
            name = resul.name,
            url = resul.url
        )
    }
    return map
}

data class EpisodeModel(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
fun EpisodeModel.toEpisode():EpisodeDmn{
    return EpisodeDmn(
        air_date, characters, created, episode, id, name, url
    )
}