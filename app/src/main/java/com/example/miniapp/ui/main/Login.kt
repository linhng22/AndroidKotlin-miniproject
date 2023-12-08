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
import androidx.navigation.NavHostController
import com.example.miniapp.data.LocalUser

@Composable
fun Login(usersState: UsersState, navController: NavHostController) {
    val signInState = remember {SignInState()}

    Column(modifier = Modifier) {
        Text("Login", fontSize = 40.sp)
        Text("Log in/Sign up to unlock all app features!")


        Form(signInState)

        Buttons(signInState, usersState, navController)
    }

}

@Composable
fun Form(signInState: SignInState) {
    Column {
        CustomTextField(signInState.userNameLabel, signInState.userName, signInState.onUserNameChanged)
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
fun Buttons(
    signInState: SignInState,
    usersState: UsersState,
    navController: NavHostController
) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(
            onClick = {
                if (signInState.userName.length > 4 && signInState.password.length > 4) {
                    var currentUser:LocalUser? = usersState.findUser(signInState.userName)
                    if (currentUser == null) {
                        currentUser = LocalUser(userName = signInState.userName, password = signInState.password, null)
                        usersState.insertEntity(currentUser)
                    }
                    usersState.updateUser(currentUser)
                    navController.navigate(Screen.HOME.route)
                }
            }
        ) {
            Text(text = "Log in", fontSize = 30.sp)
        }
    }
}