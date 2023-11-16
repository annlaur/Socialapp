package com.example.socialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialapp.ui.theme.SocialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialAppTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private  fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
){
    Column(modifier = modifier.padding(4.dp)) {
        for (name in names) {
            Greeting(name = name, modifier = modifier.fillMaxWidth())
        }
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color=MaterialTheme.colorScheme.primary, modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)){
        Row(modifier = modifier.padding(24.dp)){
            Column(modifier = modifier.weight(1f)) {//modifier.padding Applique du padding a tout les enfants de Column
                Text(text = "Hello ")
                Text(text = "$name!")
            }
            ElevatedButton(onClick = { /*TODO*/ }) {
                Text("Show More")
            }
        }
    }
}


@Preview(showBackground = true, name="courses 1 preview", widthDp = 320)
@Composable
fun GreetingPreview() {
    SocialAppTheme {
        MyApp()
    }
}
@Composable
private fun HomeActivity(
    modifier:Modifier = Modifier,
    //utilisateur: String = "Lucy",
    titres: List<String> = listOf("Beer Pong","Pétanque", "Soirée Halloween"),
    dates: List<String> = listOf("22/10","27/10","05,11"),
    heures: List<Int> = listOf(20,21,19),
    logos: List<Int> = listOf(R.drawable.beerpong, R.drawable.halloween, R.drawable.petanque)

) {
    Column(modifier = modifier.padding(4.dp)) {
        for (i in titres.indices) {
            val titre = titres[i]
            val date = dates[i]
            val heure = heures[i]
            val logo = logos[i]
            EventCard(titre = titre, logo = logo, date = date, heure = heure, modifier = modifier.fillMaxWidth())
        }
    }
}

@Composable
fun EventCard(titre: String, logo: Int, date: String, heure:Int, modifier: Modifier ){/*TODO : changer type date en Date*/
    Surface(color=MaterialTheme.colorScheme.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp).fillMaxWidth()){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(24.dp)) {
            Image(
                painter = painterResource(logo),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(horizontalAlignment = Alignment.End, modifier=modifier.weight(1f)) {
                Text(titre)
                Text("$date à $heure")
            }
        }
    }

}


@Preview(showBackground = true, name="home", widthDp = 320)
@Composable
fun HomePreview(){
    //EventCard(titre = "Halloween", logo = R.drawable.beerpong, date = "22/10", heure = 19)
    HomeActivity()
}