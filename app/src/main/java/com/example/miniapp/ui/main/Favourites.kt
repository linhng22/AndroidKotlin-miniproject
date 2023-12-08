package com.example.miniapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miniapp.data.Anime

@Composable
fun Favourites(favouriteList: MutableList<Anime>, navController: NavHostController) {
    if (favouriteList.size == 0) {
        Text("You have no favourite animes!", fontSize = 30.sp, textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp, 200.dp))
    } else {
        LazyVerticalGrid(
            GridCells.Fixed(2),
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.White)
        ) {
            items(favouriteList.size) { index ->
                AnimeItem(anime = favouriteList[index], navController)
            }
        }
    }
}
