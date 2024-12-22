package ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit

import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    // https://www.omdbapi.com/?apikey=<YourApiKey>&type=movie&s=1900&page=1
    @GET("/")
    suspend fun findMovies(
        @Query("apikey") apikey: String,
        @Query("s") searchTerm: String,
        @Query("type") type: String = "movie",
        @Query("page") page: Int = 1
    ) : SearchResultResponse
}