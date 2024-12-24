package ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("movie")
data class MovieResponse(
    val Title: String,
    val Year: String,
    @PrimaryKey // imdb id is unique for each movie
    val imdbID: String,
    val Type: String, // movie, series, episode
    val Poster: String, // image url
)
