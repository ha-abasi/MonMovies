package ir.hamedabasi.android.kotlin.compose.omdb_movie.navigation

sealed class Screen(val route: String) {
    data object Splash: Screen("splash_screen")
    data object MovieList: Screen("movies_screen")
    data object MovieSingle: Screen("movie_screen/{imdbID}"){
        fun passImdbID(imdbID: String) : String{
            return "movie_screen/$imdbID"
        }
    }
}