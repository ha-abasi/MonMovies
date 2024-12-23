package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel.MovieViewModel

@Composable
fun MovieScreen(movieViewModel: MovieViewModel){


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(paddingValues = innerPadding)){

            if (movieViewModel.movieResponse == null) {
                items(arrayOf(1)){
                    Text("No Data To Display")
                }
            }else{
                items(movieViewModel.movieResponse!!.Search){ movie ->
                    MovieItem(movie)
                }
            }

        }
    }


}