package com.example.miniapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.miniapp.data.Anime

@Composable
fun Details(
    id: Int,
    animeListState: AnimeListState,
    favouriteList: MutableList<Anime>,
    navController: NavHostController
) {

    var anime: Anime? = null
    for (i in 0..<animeListState.animes.value.size) {
        if (animeListState.animes.value.get(i).id == id) {
            anime = animeListState.animes.value.get(i)
        }
    }

    if (anime != null) {
        showDetails(anime, favouriteList, navController)
    }


}

@Composable
fun showDetails(anime: Anime, favouriteList: MutableList<Anime>, navController: NavHostController) {
    var isFavourited = favouriteList.contains(anime)

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text("${anime.titles[0].title}", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text("${anime.titles[1].title}", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Row(modifier = Modifier
                .padding(0.dp, 20.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                AsyncImage(
                    model = anime.images.jpg.imageURL,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)

                )
                OtherInfo(anime, isFavourited)
            }

            FavouriteButton(anime = anime, isFavourited = isFavourited,
                favouriteList = favouriteList, navController = navController)

            Description(anime = anime)

        }
    }
}

@Composable
fun OtherInfo(anime: Anime, isFavourited: Boolean) {
    Column (
        modifier = Modifier,
    ) {
        Text("${anime.type} (${anime.episodes} episodes)", fontSize = 22.sp)
        Text("Year: ${anime.year}", fontSize = 22.sp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = Color(0xFF4CAF50))
            Text(" ${anime.score}", fontSize = 22.sp)
        }
        Text("\t\t(${anime.scored_by} users)", fontSize = 18.sp)
        Text("Ranked #${anime.rank}", fontSize = 22.sp)

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!isFavourited) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = null, tint = Color.Red)
                Text(" ${anime.favorites}", fontSize = 22.sp)
            } else {
                Icon(Icons.Outlined.Favorite, contentDescription = null, tint = Color.Red)
                Text(" ${anime.favorites!! + 1}", fontSize = 22.sp)
            }
        }
    }
}

@Composable
fun Description(anime: Anime) {
    Column(
        modifier = Modifier.padding(15.dp, 20.dp),
        horizontalAlignment = Alignment.Start) {
        Text("Description", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("${anime.synopsis}", fontSize = 20.sp)
    }
}

@Composable
fun FavouriteButton(anime: Anime, isFavourited:Boolean, favouriteList:MutableList<Anime>, navController:NavController) {
    var buttonText = if (isFavourited) {
        "Remove from Favourites"
    } else {
        "Add to Favourites"
    }

    Button(
        modifier = Modifier
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)),
        onClick = {
            if (!isFavourited) {
                favouriteList.add(anime)
            } else {
                favouriteList.remove(anime)
            }
            navController.navigate("${Screen.DETAILS.route}/${anime.id}")
        }
    ) {
        Text(text = buttonText, fontSize = 22.sp)
    }
}
