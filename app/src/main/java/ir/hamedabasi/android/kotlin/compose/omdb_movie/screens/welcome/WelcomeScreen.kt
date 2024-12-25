package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens.welcome

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hamedabasi.android.kotlin.compose.omdb_movie.invert

@Composable
fun WelcomeScreen(){

    val pages = listOf(WelcomeScreenModel.PageWelcome, WelcomeScreenModel.PageSearch, WelcomeScreenModel.PageTerm)

    val bgColor = if (isSystemInDarkTheme()) Color.Black else Color.White

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })

    Column(
        modifier = Modifier.fillMaxSize().background(bgColor)
    ){
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxHeight(0.8f)) {
            PagerScreen(pages[it], bgColor)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(20.dp), horizontalArrangement = Arrangement.Center)
        {
            repeat(pages.size){
                val currentColor = if (pagerState.currentPage == it) bgColor else bgColor.invert()
                Box(modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(currentColor)
                    .border(BorderStroke(1.dp, bgColor.invert()), shape = CircleShape)
                    .size(16.dp))
            }

        }

    }
}

@Composable
private fun PagerScreen(screen: WelcomeScreenModel, bgColor: Color) {
    val invertedColor = bgColor.invert() // text should be inverted of bgcolor
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painterResource(screen.image), contentDescription = "", modifier = Modifier.padding(30.dp), colorFilter = ColorFilter.tint(invertedColor))
        Spacer(Modifier.height(20.dp))
        Text(screen.title, fontWeight = FontWeight.Bold, fontSize = 23.sp, textAlign = TextAlign.Center,modifier = Modifier.padding(10.dp), color = invertedColor)
        Spacer(Modifier.height(0.dp))
        Text(screen.description, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Italic, fontSize = 14.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp), color = invertedColor)
    }
}


@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun WelcomeScreenDarkPreview() {
    WelcomeScreen()
}