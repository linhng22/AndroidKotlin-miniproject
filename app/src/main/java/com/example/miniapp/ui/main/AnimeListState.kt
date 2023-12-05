package com.example.miniapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.miniapp.data.Anime
import com.example.miniapp.data.AnimeRepository

class AnimeListState (private val animeRepository: AnimeRepository) {
    var animes : MutableState<List<Anime>> = mutableStateOf(emptyList())

    suspend fun getAnimes() {
        animes.value = animeRepository.getAnime().animeList
        println(animes.value.get(0).id)
        println(animes.value.get(0).titles[0].title)
        println(animes.value.get(0).images.jpg.imageURL)
        println(animes.value.get(0).episodes)
        println(animes.value.get(0).favorites)
        println(animes.value.get(0).synopsis)
        println(animes.value.get(0).year)
    }


}