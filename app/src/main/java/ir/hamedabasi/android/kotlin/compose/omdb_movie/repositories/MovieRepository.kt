package ir.hamedabasi.android.kotlin.compose.omdb_movie.repositories

import android.content.Context
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ApiKey
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.RetrofitInstance
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.MovieResponse
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.SearchResultResponse
import ir.hamedabasi.android.kotlin.compose.omdb_movie.room.MovieDatabase

class MovieRepository(ctx: Context) {

    // online :
    suspend fun searchMovie(movieTitle: String): SearchResultResponse? {
        try {
            return RetrofitInstance.api.findMovies(ApiKey.API_KEY, movieTitle)
        }catch (th: Throwable){
            return null
        }
    }

    // offline :
    private val db: MovieDatabase = MovieDatabase.getInstance(ctx)

    suspend fun insertAll(items: List<MovieResponse>){
        return db.dao.insertMovieList(items)
    }
    suspend fun getAll(): List<MovieResponse>{
        return db.dao.getAllMovies()
    }
}