package com.example.miniapp.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.miniapp.data.LocalUser
import com.example.miniapp.data.UsersRepository

class UsersState (private val usersRepository: UsersRepository) {
    var user by mutableStateOf(LocalUser("", null, ""))

    fun insertEntity(user: LocalUser){
        usersRepository.insertEntity(user)
    }

    fun findUser(userName : String) : LocalUser? {
        return usersRepository.findUser(userName)
    }


    fun updateUser(currentUser : LocalUser) : Unit {
        user = currentUser
    }
}