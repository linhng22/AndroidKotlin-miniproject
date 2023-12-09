package com.example.miniapp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


enum class Screen(val route:String) {
    SIGNIN("signin"),
    HOME("home"),
    DETAILS("details"),
    FAVOURITES("favourites"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    animeListState: AnimeListState,
    usersState: UsersState,
    favouriteListState: AnimeListState
) {
    val navController = rememberNavController()
    favouriteListState.refreshFavouriteList(usersState.user.favouriteAnimeIDs, animeListState)
    Scaffold (
        topBar = {
            TopNavBar(navController = navController, usersState.user)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.SIGNIN.route,
            builder = {
                composable(Screen.SIGNIN.route) {
                    Signin(usersState, navController)
                }
                composable(Screen.HOME.route) {
                    Home(animeListState = animeListState, navController, usersState.user)
                }
                composable("${Screen.DETAILS.route}/{id}",
                    arguments = listOf(
                        navArgument("id"){
                            type = NavType.IntType
                        }
                    )) {
                    var id = it.arguments?.getInt("id")
                    Details(id!!, animeListState = animeListState, favouriteListState,
                        navController, usersState.user)
                }
                composable(Screen.FAVOURITES.route) {
                    Favourites(favouriteListState, navController)
                }
            }
        )
    }

}