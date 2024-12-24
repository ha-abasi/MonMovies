package ir.hamedabasi.android.kotlin.compose.omdb_movie.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.hamedabasi.android.kotlin.compose.omdb_movie.retrofit.responses.MovieResponse

@Dao
interface MovieDAO {
    @Insert
    suspend fun insert(movie: MovieResponse)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovieList(movie: List<MovieResponse>)
    @Query("select * from movie")
    suspend fun getAllMovies(): List<MovieResponse>
}