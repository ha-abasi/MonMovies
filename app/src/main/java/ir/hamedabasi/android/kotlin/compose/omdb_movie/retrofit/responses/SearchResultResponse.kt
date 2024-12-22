package ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses

data class SearchResultResponse(
    val totalResults: String,
    val Response: String,
    val Search: List<MovieResponse>
)
