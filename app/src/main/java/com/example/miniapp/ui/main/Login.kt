package com.example.miniapp.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miniapp.data.LocalUser

@Composable
fun Login(usersState: UsersState) {
    val signInState = remember {SignInState()}

    Column(modifier = Modifier) {
        Text("Login", fontSize = 40.sp)

        Form(signInState)

        Buttons(signInState, usersState)
    }

}

@Composable
fun Form(signInState: SignInState) {
    Column {
        CustomTextField(signInState.nameLabel, signInState.name, signInState.onNameChanged)
        CustomTextField(signInState.emailLabel, signInState.email, signInState.onEmailChanged)
        CustomTextField(signInState.passwordLabel, signInState.password, signInState.onPasswordChanged)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(label:String, value: String, onValueChanged: (String) -> Unit) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = label,
            modifier = Modifier
        )
        TextField(
            value = value,
            onValueChange = {
                onValueChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun Buttons(signInState: SignInState, usersState: UsersState) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(
            onClick = {
//                usersState.insertEntity(LocalUser(uid = signInState.uid.toInt(), name = signInState.name, email = signInState.email))
            }
        ) {
            Text(text = "Add", fontSize = 30.sp)
        }
        Button(onClick = {
            usersState.refresh()
        }) {
            Text(text = "Refresh", fontSize = 30.sp)
        }
    }
}