package ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.hamedabasi.android.kotlin.compose.omdb_movie.repositories.MovieRepository

class MovieViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(MovieRepository()) as T
        }

        throw IllegalArgumentException("Unknown model")
    }

}