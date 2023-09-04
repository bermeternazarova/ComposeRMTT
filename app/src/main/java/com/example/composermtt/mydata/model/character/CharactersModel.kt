package com.example.composermtt.mydata.model.character

import com.example.composermtt.domain.model.CharactersDmn
import com.example.composermtt.domain.model.InfoDmn
import com.example.composermtt.domain.model.LocationDmn
import com.example.composermtt.domain.model.LocationLocationDmn
import com.example.composermtt.domain.model.OriginDmn

data class CharactersModel(
    val info: InfoModel,
    val results: List<ResultModel>,
)
fun CharactersModel.toListCharactersModel():List<CharactersDmn>{
    val resultMap = results.mapIndexed { index, resultModel ->
        CharactersDmn(
            id = resultModel.id,
            name = resultModel.name,
            species = resultModel.species,
            image = resultModel.image,
        )
    }
    return resultMap
}

data class InfoModel(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)
fun InfoModel.toInfo():InfoDmn{
    return InfoDmn(
        count=count, next=next, pages=pages, prev=prev
    )
}

data class ResultModel(
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

data class LocationModel(
    val name: String,
    val url: String,
    val created: String,
    val dimension: String,
    val id: Int,
    val residents: List<String>,
    val type: String
)
fun LocationModel.toLocation(): LocationLocationDmn {
    return LocationLocationDmn(
        name = name,
        url = url,
        created = created,
        dimension = dimension,
        id = id,
        residents = residents,
        type = type
    )
}


data class OriginModel(
    val name: String,
    val url: String
)
fun OriginModel.toOrigin():OriginDmn{
    return OriginDmn(
        name = name,
        url = url
    )
}
