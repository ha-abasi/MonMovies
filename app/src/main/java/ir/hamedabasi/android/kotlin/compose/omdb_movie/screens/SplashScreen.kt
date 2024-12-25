package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ir.hamedabasi.android.kotlin.compose.omdb_movie.R
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ui.theme.Purple40
import ir.hamedabasi.android.kotlin.compose.omdb_movie.ui.theme.Purple80

@Composable
fun SplashScreen(){
    Splash()
}

@Composable
private fun Splash(){

    var modifier : Modifier = Modifier
    var colorFilter : ColorFilter? = null // the image taint color will be white in case of dark mode

    if (isSystemInDarkTheme()){
        modifier = modifier.background(Color.Black)
        colorFilter = ColorFilter.tint(Color.White)
    }else{
        modifier = modifier.background(Brush.horizontalGradient(listOf(Purple40, Purple80)))
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Image(painterResource(R.drawable.movie), "BMW" , colorFilter = colorFilter)
    }
}

@Preview
@Composable
private fun SplashScreenLightPreview() {
    SplashScreen()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SplashScreenNightPreview() {
    SplashScreen()
}