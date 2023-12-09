package com.example.miniapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.miniapp.data.Anime
import com.example.miniapp.data.AnimeRepository
import com.example.miniapp.data.LocalUser

class AnimeListState (private val animeRepository: AnimeRepository) {
    var animes : MutableState<List<Anime>> = mutableStateOf(emptyList())
    var favourites : MutableList<Anime> = mutableListOf()

    suspend fun getAnimes() {
        animes.value = animeRepository.getAnime().animeList
    }
    fun refreshFavouriteList(favouriteAnimeIDs: String, animeListState: AnimeListState) {
        if (favouriteAnimeIDs.isNotEmpty()) {
            val numbers: List<Int> = "\\d+".toRegex().findAll(favouriteAnimeIDs)
                .map { it.value.toInt() }
                .toList()
            for (i in numbers) {
                favourites.add(findAnimeById(i, animeListState.animes)!!)
            }
        }
    }

    fun updateFavouriteID(user:LocalUser) {
        animeRepository.updateFavouriteIDs(user)
    }

    fun findAnimeById(id: Int, allAnimes: MutableState<List<Anime>>) : Anime? {
        for (i in 0..<allAnimes.value.size) {
            if (allAnimes.value.get(i).id == id) {
                return allAnimes.value.get(i)
            }
        }
        return null
    }

    fun addFavouriteID(user: LocalUser, id: Int) {
        val newFavouriteIDs = "${id}, ${user.favouriteAnimeIDs}"
        user.favouriteAnimeIDs = newFavouriteIDs
        updateFavouriteID(LocalUser(user.userName, user.password,
            newFavouriteIDs))
    }

    fun removeFavouriteId(user: LocalUser, id: Int) {
        val numbers: List<Int> = "\\d+".toRegex().findAll(user.favouriteAnimeIDs)
            .map { it.value.toInt() }
            .toList()
        var newFavouriteIDs = ""
        for (animeID in numbers) {
            if (animeID != id) {
                newFavouriteIDs = "${animeID},${newFavouriteIDs}"
            }
        }
        user.favouriteAnimeIDs = newFavouriteIDs
        updateFavouriteID(LocalUser(user.userName, user.password, newFavouriteIDs))
    }

}