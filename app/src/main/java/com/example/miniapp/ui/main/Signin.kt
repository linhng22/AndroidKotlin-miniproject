package com.example.miniapp.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miniapp.data.LocalUser

@Composable
fun Signin(usersState: UsersState, navController: NavHostController) {
    val signInState = remember {SignInState()}
    var message  = remember {
        mutableStateOf("Sign in to unlock all app features!")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text("Sign in", fontSize = 40.sp, textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold, color = Color(0xFF33408B),
            modifier = Modifier.padding(0.dp, 80.dp, 0.dp, 0.dp)
        )

        Text(message.value, fontSize = 17.sp,textAlign = TextAlign.Center,
            color = Color.Red, modifier = Modifier.padding(40.dp, 10.dp))


        Form(signInState)

        Buttons(signInState, usersState, navController, message)
    }

}

@Composable
fun Form(signInState: SignInState) {
    Column (
        modifier = Modifier.padding(20.dp, 10.dp)
    ) {
        CustomTextField(signInState.userNameLabel, signInState.userName, signInState.onUserNameChanged)
        CustomTextField(signInState.passwordLabel, signInState.password, signInState.onPasswordChanged)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(label:String, value: String, onValueChanged: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(0.dp, 10.dp)
    ) {
        Text(
            text = label,
            fontSize = 20.sp,
            modifier = Modifier
        )
        TextField(
            value = value,
            onValueChange = {
                onValueChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0x1B3F51B5))

        )
    }
}

@Composable
fun Buttons(
    signInState: SignInState,
    usersState: UsersState,
    navController: NavHostController,
    message: MutableState<String>
) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.Center) {
        Button(
            modifier = Modifier
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color(0xFF3F51B5)),
            onClick = {
                signIn(signInState, usersState, navController, message)
            }
        ) {
            Text(text = "Sign in", fontSize = 25.sp, color = Color(0xFF3F51B5))
        }
    }
}

fun signIn(
    signInState: SignInState,
    usersState: UsersState,
    navController: NavHostController,
    message: MutableState<String>
) {
    if (signInState.userName.length > 4 && signInState.password.length > 4) {
        var currentUser:LocalUser? = usersState.findUser(signInState.userName)
        if (currentUser == null) {
            currentUser = LocalUser(userName = signInState.userName, password = signInState.password, "")
            usersState.insertEntity(currentUser)
        }
        usersState.updateUser(currentUser)
        navController.navigate(Screen.HOME.route)
    } else {
        message.value = "User name and password must have at least 5 characters!"
    }
}