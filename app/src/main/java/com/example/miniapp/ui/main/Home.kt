package com.example.miniapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.miniapp.data.Anime
import com.example.miniapp.data.LocalUser

@Composable
fun Home(animeListState: AnimeListState, navController: NavController, user: LocalUser) {
    Text("Welcome ${user.userName}!", fontSize = 30.sp)
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier
            .padding(5.dp, 10.dp)
            .background(Color.White)
    ) {
        items(animeListState.animes.value.size) { index ->
            AnimeItem(anime = animeListState.animes.value[index], navController)
        }
    }

}

@Composable
fun AnimeItem(anime: Anime, navController: NavController) {
    val title : String
    if (anime.titles[0].title.length > 25) {
        title = "${anime.titles[0].title.take(25)}..."
    } else title = anime.titles[0].title
    Column(
        modifier = Modifier
            .padding(5.dp, 10.dp)
            .size(270.dp)
            .clickable {
                println("Home, animeID = ${anime.id}")
                navController.navigate("${Screen.DETAILS.route}/${anime.id}")
            },
    ){
        AsyncImage(
            model = anime.images.jpg.imageURL,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(10.dp))

        )
        Text(text = title, fontSize = 20.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("${anime.type} (${anime.episodes} eps) ")
            Icon(Icons.Rounded.Star, contentDescription = null, tint = Color(0xFF4CAF50))
            Text(" ${anime.score}")
        }
    }
}
