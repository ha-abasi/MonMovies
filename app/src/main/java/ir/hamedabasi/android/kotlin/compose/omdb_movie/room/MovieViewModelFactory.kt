package ir.hamedabasi.android.kotlin.compose.omdb_movie.room

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.MovieResponse
import ir.hamedabasi.android.kotlin.compose.omdb_movie.room.repositories.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModelFactory(repository: MovieRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(MovieRepository()) as T
        }

        throw IllegalArgumentException("Unknown model")
    }

}