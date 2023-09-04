package com.example.composermtt.mydata.model

import com.example.composermtt.domain.model.LocationLocationDmn
import com.example.composermtt.mydata.model.character.InfoModel

data class LocationsModel(
    val info: InfoModel,
    val results: List<LocationLocation>
)
fun LocationsModel.toListLocations(): List<LocationLocationDmn> {
    val map = results.mapIndexed { index, resul ->
        LocationLocationDmn(
            created = resul.created,
            dimension = resul.dimension,
            id = resul.id,
            name = resul.name,
            type = resul.type,
            residents = resul.residents,
            url  = resul.url
        )
    }
    return map
}
data class LocationLocation(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)
fun LocationLocation.toLocationLocation(): LocationLocationDmn {
    return LocationLocationDmn(
        created, dimension, id, name, residents, type, url
    )
}