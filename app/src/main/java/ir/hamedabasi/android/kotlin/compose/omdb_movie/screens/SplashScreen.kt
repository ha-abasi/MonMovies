package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens

import android.content.res.Configuration
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.rotate

@Composable
fun SplashScreen(){


    val rotationDegree = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        rotationDegree.animateTo(
            360f,
            animationSpec = tween(1000, 300)
        )
    }

    Splash(rotationDegree.value)
}

@Composable
private fun Splash(rotationDegree: Float){

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
        Image(
            painterResource(R.drawable.movie),
            contentDescription = "Movie" ,
            colorFilter = colorFilter,
            modifier = Modifier.rotate(rotationDegree),
        )
    }
}

@Preview
@Composable
private fun SplashScreenLightPreview() {
    Splash(0f)
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SplashScreenNightPreview() {
    Splash(0f)
}