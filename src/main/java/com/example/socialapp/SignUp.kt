package com.example.socialapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialapp.ui.theme.DarkGreen
import com.example.socialapp.ui.theme.EceGreen
import com.example.socialapp.ui.theme.LightGray
import com.example.socialapp.ui.theme.LightGreen
import com.example.socialapp.ui.theme.White
import com.example.socialapp.ui.theme.Yellow



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    // État pour les valeurs de saisie
    val prenom = remember { mutableStateOf(TextFieldValue()) }
    val nom = remember { mutableStateOf(TextFieldValue()) }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val schools = listOf("HEI", "ECE", "Sup de Pub")
    var expanded by remember { mutableStateOf(false) }
    var selectedSchool by remember { mutableStateOf(schools[0]) }

    Column(
        modifier = Modifier.padding(16.dp).background(EceGreen)
    ) {
        Text(text = "Créer un compte", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = prenom.value,
            onValueChange = { prenom.value = it },
            label = { Text("Prénom") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = LightGray,
                    focusedBorderColor = LightGreen,
                    unfocusedBorderColor = DarkGreen,
                    textColor = White,
                    cursorColor = White
        )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nom.value,
            onValueChange = { nom.value = it },
            label = { Text("Nom") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = LightGray)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = LightGray)
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = LightGray)
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = selectedSchool,
            onValueChange = { selectedSchool = it },
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { expanded = true },
            label = { Text("École") },
            trailingIcon = {
                /*TODO : icone menu deroulant*/
            },
            readOnly = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Gray
            )
        )

        /*DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            schools.forEach {  school  ->
                DropdownMenuItem(
                    onClick = {
                        selectedSchool = school
                        expanded = false
                    }
                ) {
                    Text(text = school)
                }
            }
        }*/

        /*TODO : faire une fonction composable input pour alléger le code*/
        /*TODO : faire le dropdown menu*/
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Logique d'inscription
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Yellow,
                contentColor = DarkGreen
            ),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("M'enregistrer")
        }
    }
}
/*TODO : mettre le background vert*/


@Preview(showBackground = true, backgroundColor = 0xFF09655E, name="home", widthDp = 320)
@Composable
fun RegisterPreview(){
    //EventCard(titre = "Halloween", logo = R.drawable.beerpong, date = "22/10", heure = 19)
    RegisterScreen()
}
