package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.MovieResponse

@Composable
fun MovieItem(movie: MovieResponse){
    Card(elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.padding(2.dp)){
            AsyncImage(model = movie.Poster, contentDescription = "", modifier = Modifier.padding(5.dp).width(60.dp).border(2.dp,Color.Black,
                RoundedCornerShape(6.dp)
            ))
            Column(modifier = Modifier.padding(4.dp)){
                Text(movie.Title, style = MaterialTheme.typography.titleMedium)
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize().padding(4.dp)){
                    Row {
                        Text("Year: ", style = MaterialTheme.typography.titleSmall, color = Color.Gray)
                        Text(movie.Year, style = MaterialTheme.typography.titleSmall, color = Color.Black)
                    }
                    Row {
                        Text("Type: ", style = MaterialTheme.typography.titleSmall, color = Color.Gray)
                        Text(movie.Type, style = MaterialTheme.typography.titleSmall, color = Color.Black)
                    }
                }

            }

        }
    }
}