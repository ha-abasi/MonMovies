package ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses

data class MovieResponse(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String, // movie, series, episode
    val Poster: String, // image url

)
