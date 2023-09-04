@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composermtt.presentation.screens.location

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
import com.example.composermtt.domain.model.LocationLocationDmn
import com.example.composermtt.presentation.uiBase.MyBottomBar
import com.example.composermtt.presentation.uiBase.MyTopBar
import com.example.composermtt.presentation.uiBase.ProgressIndicatorScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    itemClick :(Int) -> Unit,
    viewModel: LocationsViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            MyTopBar(name = "LocationFragment")
        },
        bottomBar = {
            MyBottomBar(showPrevious = state.showPreview,
                showNext =state.showNext ,
                onPreviousPressed = {
                    viewModel.getLocations(false)
                },
                onNextPressed = {
                    viewModel.getLocations(true)
                }
            )
        }
    ){innerPadding ->
        LocationContent(
            modifier = Modifier
                .padding(innerPadding),
            onItemClick ={
                itemClick(it)
            } ,
            isLoading = state.isLoading,
            location = state.locations,
        )
    }
}

@Composable
private fun LocationContent(
    modifier: Modifier =Modifier,
    onItemClick:(Int)->Unit,
    isLoading :Boolean =false,
    location:List<LocationLocationDmn>
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
                items(location.size){ index->
                    LocationItem(modifier = Modifier
                        .fillMaxWidth(),
                        item = location[index],
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