package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel.MovieViewModel

@Composable
fun MovieScreen(movieViewModel: MovieViewModel){

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(paddingValues = innerPadding)){
            items(arrayOf(1)){
                ConnectionComponents(movieViewModel)
            }
            if (movieViewModel.movieResponse == null) {
                items(arrayOf(1)){
                    Text("No Data To Display")
                }
            }else{
                items(movieViewModel.movieResponse!!){ movie ->
                    MovieItem(movie)
                }
            }

        }
    }
}

// Radio
@Composable
fun ConnectionComponents(movieViewModel: MovieViewModel){
    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = movieViewModel.connectionType == "Online",
            onClick = { movieViewModel.setConnType("Online");movieViewModel.refresh()},
            interactionSource = remember { MutableInteractionSource() }
        )
        Text("Online")
    }
    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = movieViewModel.connectionType == "Offline",
            onClick = { movieViewModel.setConnType("Offline");movieViewModel.refresh()},
            interactionSource = remember { MutableInteractionSource() }
        )
        Text("Offline")
    }
}