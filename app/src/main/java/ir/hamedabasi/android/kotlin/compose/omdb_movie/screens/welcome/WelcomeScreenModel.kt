package ir.hamedabasi.android.kotlin.compose.omdb_movie.screens.welcome

import ir.hamedabasi.android.kotlin.compose.omdb_movie.R

sealed class WelcomeScreenModel(val image: Int,val title: String,val description: String) {
    data object PageWelcome : WelcomeScreenModel(R.mipmap.welcome, "Welcome to movie search", "We would like to show our welcome to you as you use this application on daily routine !")
    data object PageSearch : WelcomeScreenModel(R.mipmap.search, "Accurate Search", "Here you can search any movie any time, we have used an comprehensive database !")
    data object PageTerm : WelcomeScreenModel(R.mipmap.law, "Rule Of Usage", "you should limit your search terms to just safe words don't misuse the application !")
}