@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composermtt.presentation.screens.episode

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composermtt.domain.model.EpisodeDmn
import com.example.composermtt.presentation.uiBase.MyBottomBar
import com.example.composermtt.presentation.uiBase.MyTopBar
import com.example.composermtt.presentation.uiBase.ProgressIndicatorScreen

@Composable
fun EpisodeScreen(
    itemClick :(Int) -> Unit,
    viewModel: EpisodesViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
           MyTopBar(name = "EpisodeFragment")
        },
        bottomBar = {
            MyBottomBar(showPrevious = state.showPreview,
                showNext =state.showNext ,
                onPreviousPressed = {
                    viewModel.getEpisodes(false)
                },
                onNextPressed = {
                    viewModel.getEpisodes(true)
                }
            )
        }
    ){innerPadding ->
        EpisodeContent(
            modifier = Modifier
                .padding(innerPadding),
            onItemClick ={
                itemClick(it)
            } ,
            isLoading = state.isLoading,
            episode = state.episodes,
        )
    }
}

@Composable
private fun EpisodeContent(
    modifier: Modifier =Modifier,
    onItemClick:(Int)->Unit,
    isLoading :Boolean =false,
    episode:List<EpisodeDmn>
){
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 6.dp),
            modifier = Modifier
                .fillMaxWidth(),
            content = {
                items(episode.size){ index->
                    EpisodeItem(modifier = Modifier
                        .fillMaxWidth(),
                        item = episode[index],
                        onItemClick ={
                            onItemClick(it) }
                    )
                }
            }
        )
        if (isLoading){
            ProgressIndicatorScreen()
        }
    }
}