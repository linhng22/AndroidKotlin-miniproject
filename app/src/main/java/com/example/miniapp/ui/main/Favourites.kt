package com.example.miniapp.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Favourites(favouriteListState: AnimeListState, navController: NavHostController) {
    if (favouriteListState.favourites.size == 0) {
        EmptyList(navController = navController)
    } else {

        Column(
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("My Favourites", fontSize = 25.sp,
                color = Color(0xFFFF5722),
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 5.dp),
                fontWeight = FontWeight.Bold
            )
            LazyVerticalGrid(
                GridCells.Fixed(2),
                modifier = Modifier
                    .padding(5.dp, 10.dp)
                    .background(Color.White)
            ) {
                items(favouriteListState.favourites.size) { index ->
                    AnimeItem(anime = favouriteListState.favourites[index], navController)
                }
            }
        }
    }
}

@Composable
fun EmptyList(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "You haven't added favourite animes!",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(30.dp, 100.dp, 30.dp, 50.dp)
        )
        Button(
            modifier = Modifier
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color(0xFF3F51B5)),
            onClick = {
                navController.navigate(Screen.HOME.route)
            }
        ) {
            Text(text = "Go to Home", fontSize = 25.sp, color = Color(0xFF3F51B5))
        }
    }
}