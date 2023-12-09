package com.example.miniapp.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AnimeRepository(private val client: HttpClient, private val dao: Dao) {
    suspend fun getAnime() : AnimeList {
        val response = client.get(APIEndPoint.FIELDS1.url)
        val json = response.body<JsonObject>().toString()
        return deserializeJson(json)
    }

    private fun deserializeJson(json: String): AnimeList {
        return Gson().fromJson(json, AnimeList::class.java)
    }

    fun updateFavouriteIDs(user:LocalUser) {
        dao.insert(user)
    }

}