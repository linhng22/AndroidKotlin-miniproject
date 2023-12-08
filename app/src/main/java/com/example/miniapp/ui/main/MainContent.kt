package com.example.miniapp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.miniapp.data.Anime


enum class Screen(val route:String) {
    LOGIN("login"),
    HOME("home"),
    DETAILS("details"),
    FAVOURITES("favourites"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    animeListState: AnimeListState,
    usersState: UsersState
) {
    val navController = rememberNavController()
    var favouriteList = remember { mutableListOf<Anime>() }

    Scaffold (
        topBar = {
            TopNavBar(navController = navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.HOME.route,
            builder = {
                composable(Screen.LOGIN.route) {
                    Login(usersState)
                }
                composable(Screen.HOME.route) {
                    Home(animeListState = animeListState, navController)
                }
                composable("${Screen.DETAILS.route}/{id}",
                    arguments = listOf(
                        navArgument("id"){// because {image} is string by default
                            type = NavType.IntType
                        }
                    )) {
                    var id = it.arguments?.getInt("id")
                    println("anime id: ${id}")
                    Details(id!!, animeListState = animeListState, favouriteList, navController)
                }
                composable(Screen.FAVOURITES.route) {
                    Favourites(favouriteList, navController)
                }
            }
        )
    }

}