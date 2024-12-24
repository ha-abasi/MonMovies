package ir.hamedabasi.android.kotlin.compose.omdb_movie.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.MovieResponse

@Database(entities = [MovieResponse::class], version = 1)
abstract class MovieDatabase : RoomDatabase(){
    abstract val dao: MovieDAO

    // `companion object` ensures static singleton
    companion object {
        @Volatile // ensure thread safety around the object (race condition)
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context) : MovieDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){ // just one thread can be here !
                    instance = Room
                        .databaseBuilder(context, MovieDatabase::class.java, "dbMovie")
                        .build()
                }
                INSTANCE = instance

                return instance
            }
        }
    }
}