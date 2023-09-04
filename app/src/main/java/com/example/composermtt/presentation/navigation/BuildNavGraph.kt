package com.example.composermtt.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composermtt.mydata.base.BaseViewModel
import com.example.composermtt.presentation.screens.MainScreen
import com.example.composermtt.presentation.screens.character.CharacterScreen
import com.example.composermtt.presentation.screens.episode.EpisodeScreen
import com.example.composermtt.presentation.screens.location.LocationScreen
import com.example.composermtt.presentation.screens.splash.SplashScreen

@Composable
fun BuildNavGraph(
    navController: NavHostController,
    viewModel: BaseViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoad.Splash.path
    ) {
        addSplashScreen(navController, this)
        addMainScreen(navController, this, viewModel)
        addCharacterScreen(navController, this, viewModel)
        addEpisodeScreen(navController, this, viewModel)
        addLocationScreen(navController, this, viewModel)
    }

}

fun addLocationScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: BaseViewModel
) {
    navGraphBuilder.composable(route = NavigationRoad.Location.path) {
        LocationScreen(
            itemClick = {

            }
        )
    }

}

fun addEpisodeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: BaseViewModel
) {
    navGraphBuilder.composable(route = NavigationRoad.Episode.path) {
        EpisodeScreen(
            itemClick = {

            }
        )
    }

}

fun addCharacterScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: BaseViewModel
) {
    navGraphBuilder.composable(route = NavigationRoad.Character.path) {
        CharacterScreen(
            itemClick = {

            }
        )

    }

}

fun addMainScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    viewModel: BaseViewModel
) {
    navGraphBuilder.composable(route = NavigationRoad.Main.path) {
        MainScreen(navController = navController)
    }

}

fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavigationRoad.Splash.path) {
        SplashScreen(navController = navController)
    }
}
