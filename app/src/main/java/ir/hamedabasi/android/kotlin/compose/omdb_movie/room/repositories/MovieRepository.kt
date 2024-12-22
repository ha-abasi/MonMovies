package ir.hamedabasi.android.kotlin.compose.omdb_movie.room.repositories

import ir.hamedabasi.android.kotlin.compose.omdb_movie.ApiKey
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.RetrofitInstance
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.SearchResultResponse

class MovieRepository {

    suspend fun searchMovie(movieTitle: String): SearchResultResponse {
        return RetrofitInstance.api.findMovies(ApiKey.API_KEY, movieTitle)
    }
}