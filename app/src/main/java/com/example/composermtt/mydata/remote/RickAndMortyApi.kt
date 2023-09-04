package com.example.composermtt.mydata.remote

import com.example.composermtt.mydata.model.CharactersModel
import com.example.composermtt.mydata.model.EpisodesModel
import com.example.composermtt.mydata.model.LocationsModel
import com.example.composermtt.mydata.model.character.CharacterModel
import com.example.composermtt.mydata.utils.Constants.Companion.CHARACTER_BY_ID
import com.example.composermtt.mydata.utils.Constants.Companion.CHARACTER_END_POINT
import com.example.composermtt.mydata.utils.Constants.Companion.EPISODE_END_POINT
import com.example.composermtt.mydata.utils.Constants.Companion.LOCATION_END_POINT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET(CHARACTER_END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): CharactersModel

    @GET(CHARACTER_BY_ID)
    suspend fun getCharacter(
        @Path("id") id: Int
    ): CharacterModel

    @GET(EPISODE_END_POINT)
    suspend fun getAllEpisodes(
        @Query("page") page: Int
    ): EpisodesModel

    @GET(LOCATION_END_POINT)
    suspend fun getAllLocations(
        @Query("page") page: Int
    ): LocationsModel
}