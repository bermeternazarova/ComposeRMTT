package com.example.composermtt.presentation.state

import com.example.composermtt.domain.model.CharactersDmn
import com.example.composermtt.domain.model.EpisodeDmn
import com.example.composermtt.domain.model.LocationLocationDmn

data class CharactersState(
    val characters :List<CharactersDmn> = emptyList(),
    val  showPreview:Boolean = false,
    val showNext:Boolean = false,
    val isLoading :Boolean= false
)
data class EpisodesState(
    val episodes :List<EpisodeDmn> = emptyList(),
    val  showPreview:Boolean = false,
    val showNext:Boolean = false,
    val isLoading :Boolean= false
)
data class LocationsState(
    val locations :List<LocationLocationDmn> = emptyList(),
    val  showPreview:Boolean = false,
    val showNext:Boolean = false,
    val isLoading :Boolean= false
)
