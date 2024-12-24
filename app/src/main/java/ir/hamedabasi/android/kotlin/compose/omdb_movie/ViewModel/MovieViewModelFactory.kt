package ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.hamedabasi.android.kotlin.compose.omdb_movie.repositories.MovieRepository

class MovieViewModelFactory(private val applicationContext: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(MovieRepository(applicationContext)) as T
        }

        throw IllegalArgumentException("Unknown model")
    }

}