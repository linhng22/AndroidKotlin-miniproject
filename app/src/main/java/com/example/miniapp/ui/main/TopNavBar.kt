package com.example.miniapp.ui.main

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.miniapp.data.LocalUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(navController: NavController, user: LocalUser) {

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF3F51B5)),
        title = {
            Text("Anime World", fontSize = 30.sp, color = Color.White)
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(Screen.HOME.route)
                }
            ) {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = Color.Yellow
                )

            }
            if (user.password != null){
                IconButton(
                    onClick = {
                        navController.navigate(Screen.FAVOURITES.route)
                    }
                ) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color.Red
                    )
                }
            } else {
                IconButton(
                    onClick = {
                        navController.navigate(Screen.SIGNIN.route)
                    }
                ) {
                    Icon(
                        Icons.Rounded.ExitToApp,
                        contentDescription = null,
                        Modifier.size(30.dp),
                        tint = Color.White
                    )
                }
            }

        }
    )


}