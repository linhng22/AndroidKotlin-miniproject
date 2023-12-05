package com.example.miniapp

import android.app.Application
import androidx.room.Room
import com.example.miniapp.data.AppDatabase
import com.example.miniapp.data.AnimeRepository
import com.example.miniapp.data.UsersRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MyApp : Application() {
    private val client by lazy {
        HttpClient {
            install(ContentNegotiation) {
                gson()
            }
        }
    }

    val animeRepository by lazy {
        AnimeRepository(client)
    }

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "my-cool-database"
        )
            .allowMainThreadQueries()
            .build()
    }

    val usersRepository by lazy { UsersRepository(db.userDao()) }

}