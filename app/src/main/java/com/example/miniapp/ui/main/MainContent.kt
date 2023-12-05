package com.example.miniapp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class Screen(val route:String) {
    LOGIN("login"),
    HOME("home"),
    DETAILS("details"),
    FAVOURITES("favourites"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(animeListState: AnimeListState, usersState: UsersState) {
    val navController = rememberNavController()


//    val favouriteStateList by mutableStateOf()

    Scaffold {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.LOGIN.route,
            builder = {
                composable(Screen.LOGIN.route) {
                    Login(usersState)
                }
                composable(Screen.HOME.route) {
                    Home(animeListState = animeListState)
                }
                composable("${Screen.DETAILS.route}/{id}") {
                    Details(id = it.id)
                }
                composable(Screen.FAVOURITES.route) {

                }
            }
        )
    }

}