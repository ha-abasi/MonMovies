package ir.hamedabasi.android.kotlin.compose.omdb_movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel.MovieViewModel
import ir.hamedabasi.android.kotlin.compose.omdb_movie.screens.MovieScreen
import ir.hamedabasi.android.kotlin.compose.omdb_movie.screens.SplashScreen
import ir.hamedabasi.android.kotlin.compose.omdb_movie.screens.welcome.WelcomeScreen


@Composable
fun SetUpNavGraph(movieViewModel: MovieViewModel, navController: NavHostController){
    NavHost(navController=navController, startDestination=Screen.Welcome.route){
        composable(Screen.Splash.route){
            SplashScreen()
        }
        composable(Screen.Welcome.route){
            WelcomeScreen(navController)
        }
        composable(Screen.MovieList.route){
            MovieScreen(movieViewModel)
        }
        composable(Screen.MovieSingle.route, arguments = listOf(navArgument("imdbID"){ type = NavType.StringType})){
            MovieScreen(movieViewModel)
        }
    }
}