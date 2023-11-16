package com.example.socialapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialapp.ui.theme.EceGreen


@Composable
fun LoginScreen() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(EceGreen)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Bienvenue sur EventHub",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            CustomInputField(
                label = "Email",
                textState = emailState,
                imeAction = ImeAction.Next
            )

            CustomInputField(
                label = "Password",
                textState = passwordState,
                imeAction = ImeAction.Done,
                onImeAction = { /* Handle IME Action */ }
            )

            Text(
                text = "ou",
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )

            Text(
                text = "Créer un compte.",
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )

            YellowButton(
                text = "Me connecter",
                onClick = { /* Handle click here */ },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, name="home", widthDp = 320)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
