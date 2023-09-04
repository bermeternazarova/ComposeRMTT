package com.example.composermtt.domain.model

import com.example.composermtt.mydata.model.character.LocationModel
import com.example.composermtt.mydata.model.character.OriginModel

data class CharacterDmn(
    val info: InfoDmn,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationLocationDmn,
    val name: String,
    val origin: OriginDmn,
    val species: String,
    val status: String
)
data class CharactersDmn(
    val id: Int,
    val name: String,
    val image: String,
    val species: String,
)
data class InfoDmn(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)
data class ResultDmn(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationModel,
    val name: String,
    val origin: OriginModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class LocationDmn(
    val name: String,
    val url: String
)

data class OriginDmn(
    val name: String,
    val url: String
)

