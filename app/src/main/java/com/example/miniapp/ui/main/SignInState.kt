package com.example.miniapp.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignInState {

    val userNameLabel:String = "User name"
    var userName by mutableStateOf("")
    val onUserNameChanged:(String) -> Unit = {
        userName = it
        validUserName = userName.length > 4
    }
    var validUserName = false


    val passwordLabel = "Password"
    var password by mutableStateOf("")
    val onPasswordChanged:(String) -> Unit = {
        password = it
        validPassword = password.length > 4
    }
    var validPassword = false
}