package com.example.miniapp.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignInState {
//    val uidLabel:String = "uid"
    var uid:String by mutableStateOf("")
//    val onUidChanged:(String) -> Unit = {
//        uid=it
//    }


    val nameLabel:String = "First name"
    var name by mutableStateOf("")
    val onNameChanged:(String) -> Unit = {
        name = it
    }

    val emailLabel:String = "Email address"
    var email by mutableStateOf("")
    val onEmailChanged:(String) -> Unit = {
        email = it
        validEmail = email.contains("@") //UI logic
    }

    var validEmail = false

    val passwordLabel = "Password"
    var password by mutableStateOf("")
    val onPasswordChanged:(String) -> Unit = {
        password = it
        validPassword = password.length > 4
    }
    var validPassword = false
}