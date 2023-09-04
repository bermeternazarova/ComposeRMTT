package com.example.composermtt.domain.model


data class EpisodesDmn(
    val info: InfoDmn,
    val results: List<EpisodeDmn>
)
data class EpisodeDmn(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)