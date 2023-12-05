package com.example.miniapp.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Home(animeListState : AnimeListState) {
    LazyColumn(content = {
        items(animeListState.animes.value.size) {
            Text(animeListState.animes.value[it].titles[0].title, fontSize = 30.sp)

            AsyncImage(
                model = animeListState.animes.value[it].images.jpg.imageURL,
                contentDescription = null,
                modifier = Modifier
                    .clickable {

                    })
        }
    })
}