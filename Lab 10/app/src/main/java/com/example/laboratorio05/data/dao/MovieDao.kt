package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.MovieWithActor


@Dao
interface MovieDao {
    // Realiza consulta para obtener registros y retorna una lista.
    @Query("SELECT * FROM movie_table")
    suspend fun  getAllMovies() : List<MovieModel>

    // Inserta.
    @Transaction
    @Insert
    suspend fun insertMovie(movie : MovieModel)

    // Realiza consulta y retorna un MovieWithActor.
    @Query("SELECT * FROM movie_table WHERE movieId = :movieId")
    suspend fun getMovieWithActorsById(movieId : Int) : MovieWithActor?

}