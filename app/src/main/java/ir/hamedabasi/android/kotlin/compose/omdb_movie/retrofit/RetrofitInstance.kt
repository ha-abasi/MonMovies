package ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// object is singleton
object RetrofitInstance {
    const val BASE_URL: String = "https://www.omdbapi.com/"

    // lazy ensures that api is created just when it accessed for the first time
    val api:ApiService by lazy {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}