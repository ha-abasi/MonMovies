package ir.hamedabasi.android.kotlin.compose.omdb_movie.room

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.MovieResponse
import ir.hamedabasi.android.kotlin.compose.omdb_movie.room.repositories.MovieRepository
import kotlinx.coroutines.launch

//
// ViewModel stores/manages UI related data and survives configuration changes
// it's data won't lost on configuration changes such as device screen rotation
// or app switching
//
class MovieViewModel(repository: MovieRepository) : ViewModel() {

    var movieResponse by mutableStateOf<MovieResponse?>(null)
        set

    var movieResponseFromApi by mutableStateOf<MovieResponse?>(null)
        set

    fun setMovieResponse(movieResponse: MovieResponse?){
        this.movieResponse = movieResponse
    }


    init {
        viewModelScope.launch {

        }
    }

}