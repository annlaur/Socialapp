package com.example.socialapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun EventCard(
    eventName: String,
    eventDate: String,
    eventLocation: String,
    imageRes: Int = R.drawable.beerpong
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),/*,
        elevation = CardDefaults.CardElevation(4.dp)*/
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Event Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = eventName,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = eventDate,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = eventLocation,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true, name="home", widthDp = 320)
@Composable
fun CardPreview(){
    EventCard(
        eventName = "Beer Pong, BDS",
        eventDate = "22/10 à 21h30",
        eventLocation = "Rue Sextius Michel, 75015"
        //imageRes = R.drawable.
    )
}
