@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class
)

package com.example.composermtt.presentation.screens.character


import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composermtt.R
import com.example.composermtt.domain.model.CharactersDmn
import com.example.composermtt.presentation.uiBase.MyBottomBar
import com.example.composermtt.presentation.uiBase.MyTopBar
import com.example.composermtt.presentation.uiBase.ProgressIndicatorScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterScreen(
    itemClick :(Int) -> Unit,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            MyTopBar(name = "CharacterFragment")
        },
        bottomBar = {
            MyBottomBar(showPrevious = state.showPreview,
                showNext =state.showNext ,
                onPreviousPressed = {
                    viewModel.getCharacters(false)
                },
            onNextPressed = {
                viewModel.getCharacters(true)
            }
            )
        }
    ){innerPadding ->
        CharacterContent(
            modifier = Modifier
                .padding(innerPadding),
            onItemClick ={
                    itemClick(it)
            } ,
            isLoading = state.isLoading,
            characters = state.characters,
        )
    }
}

@Composable
private fun CharacterContent(
    modifier: Modifier =Modifier,
    onItemClick:(Int)->Unit,
    isLoading :Boolean =false,
    characters:List<CharactersDmn>
){
        LazyVerticalStaggeredGrid(
            contentPadding =PaddingValues(horizontal = 6.dp, vertical = 6.dp) ,
            columns = StaggeredGridCells.Fixed(2),
            modifier = modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.backf),
                    contentScale = ContentScale.FillBounds
                ),
            content = {
                items(characters.size){index ->
                    GridCharacter(modifier = Modifier
                       .fillMaxWidth(),
                       item = characters[index],
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