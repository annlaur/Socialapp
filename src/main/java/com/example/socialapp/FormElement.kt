package com.example.socialapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.ImeAction
import com.example.socialapp.ui.theme.Yellow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInputField(
    label: String,
    textState: MutableState<String>,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: () -> Unit = {}
) {
    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(label) },
        singleLine = true,
        keyboardActions = KeyboardActions(onNext = { onImeAction() }),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray,
            textColor = Color.Black,
            containerColor = Color.LightGray // Un gris clair pour le fond des TextFields
        ),
        modifier = modifier.padding(vertical = 4.dp)
    )
}


@Composable
fun YellowButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Yellow,
            contentColor = Color.Black
        ),
        modifier = modifier.height(48.dp)
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, name="home", widthDp = 320)
@Composable
fun FormElementPreview(){
    Column {
        YellowButton(text = "test", onClick = { /*TODO*/ })
        CustomInputField(
            label = "Password",
            textState = remember { mutableStateOf("") },
            imeAction = ImeAction.Done,
            onImeAction = { /* Handle IME action */ }
        )
    }
}
