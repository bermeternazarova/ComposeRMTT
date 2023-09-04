package com.example.composermtt.domain.model

data class LocationsDmn(
    val info: InfoDmn,
    val results: List<LocationLocationDmn>
)
data class LocationLocationDmn(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)