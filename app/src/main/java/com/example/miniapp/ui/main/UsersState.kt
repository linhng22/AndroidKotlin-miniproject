package com.example.miniapp.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.miniapp.data.LocalUser
import com.example.miniapp.data.UsersRepository

class UsersState (private val usersRepository: UsersRepository) {
    var users by mutableStateOf(usersRepository.getAll())

    fun refresh(){
        users = usersRepository.getAll()
    }

    fun insertEntity(user: LocalUser){
        usersRepository.insertEntity(user)
    }

    fun deleteEntity(user: LocalUser) {
        usersRepository.deleteEntity(user)
    }

}