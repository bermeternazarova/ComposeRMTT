package com.example.composermtt.mydata.di

import com.example.composermtt.domain.repository.CharacterRepository
import com.example.composermtt.domain.repository.EpisodesRepository
import com.example.composermtt.domain.repository.LocationRepository
import com.example.composermtt.mydata.repository.CharacterRepositoryImpl
import com.example.composermtt.mydata.repository.EpisodeRepositoryImpl
import com.example.composermtt.mydata.repository.LocationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(imple:CharacterRepositoryImpl):CharacterRepository

    @Binds
    abstract fun bindEpisodeRepository(imple:EpisodeRepositoryImpl):EpisodesRepository

    @Binds
    abstract fun bindLocationRepository(imple:LocationRepositoryImpl):LocationRepository
}