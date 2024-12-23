package ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.SearchResultResponse
import ir.hamedabasi.android.kotlin.compose.omdb_movie.repositories.MovieRepository
import kotlinx.coroutines.launch

//
// ViewModel stores/manages UI related data and survives configuration changes
// it's data won't lost on configuration changes such as device screen rotation
// or app switching
//
class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    var movieResponse by mutableStateOf<SearchResultResponse?>(null)
        private set
    var movieResponseFromApi by mutableStateOf<SearchResultResponse?>(null)
        private set



    private fun refresh(){
        viewModelScope.launch {
            movieResponse = repository.searchMovie("1900")
        }
    }

    init {
        refresh()
    }

}