package com.example.miniapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.example.miniapp.ui.main.AnimeListState
import com.example.miniapp.ui.main.MainContent
import com.example.miniapp.ui.main.UsersState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animeRepository = (application as MyApp).animeRepository
        val usersRepository = (application as MyApp).usersRepository

        setContent {
            val animeListState = AnimeListState(animeRepository)
            val usersState = remember{ UsersState(usersRepository) }
            LaunchedEffect(
                key1 = animeListState,
                block = {
                    animeListState.getAnimes()
                })
            MainContent(animeListState = animeListState, usersState = usersState)
        }
    }
}

