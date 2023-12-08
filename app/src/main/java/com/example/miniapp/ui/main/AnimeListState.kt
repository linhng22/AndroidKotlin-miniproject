package com.example.miniapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.miniapp.data.Anime
import com.example.miniapp.data.AnimeRepository

class AnimeListState (private val animeRepository: AnimeRepository) {
    var animes : MutableState<List<Anime>> = mutableStateOf(emptyList())

    suspend fun getAnimes() {
        animes.value = animeRepository.getAnime().animeList
    }


}