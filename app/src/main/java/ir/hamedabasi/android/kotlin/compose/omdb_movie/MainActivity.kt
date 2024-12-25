package ir.hamedabasi.android.kotlin.compose.omdb_movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel.MovieViewModel
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ViewModel.MovieViewModelFactory
import ir.hamedabasi.android.kotlin.compose.omdb_movie.navigation.SetUpNavGraph
import ir.hamedabasi.android.kotlin.compose.omdb_movie.screens.MovieScreen
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ui.theme.OmdbMovieTheme


class MainActivity : ComponentActivity() {

    private lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //
        // Our model have parameter, so we need to use factory :
        //
        val vmF = MovieViewModelFactory(applicationContext)
        val vm = ViewModelProvider(this, vmF)[MovieViewModel::class.java]


        enableEdgeToEdge()
        setContent {
            OmdbMovieTheme {
                // NavController : it should be initialized in the composable
                navController = rememberNavController()
                SetUpNavGraph(vm, navController)
            }
        }
    }
}