package ir.hamedabasi.android.kotlin.compose.omdb_movie

import androidx.compose.ui.graphics.Color


// just invert a given color
fun Color.invert(): Color {
    return Color(
        red = 1f - red,
        green = 1f - green,
        blue = 1f - blue,
        alpha = alpha
    )
}