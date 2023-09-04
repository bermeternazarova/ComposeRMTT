package com.example.composermtt.presentation.navigation

open class NavigationRoad(val path: String) {

    object Splash:NavigationRoad("SplashScreen")
    object Main : NavigationRoad("MainScreen")
    object Character : NavigationRoad("CharacterScreen")
    object Episode : NavigationRoad("EpisodeScreen")
    object Location : NavigationRoad("LocationScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            args.forEach { arg ->
                append("/$arg")

            }
        }
    }

    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }

}