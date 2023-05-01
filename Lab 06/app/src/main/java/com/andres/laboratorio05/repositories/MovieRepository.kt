package com.andres.laboratorio05.repositories

import com.andres.laboratorio05.data.model.MovieModel

class MovieRepository (private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(newMovie: MovieModel) = movies.add(newMovie)

}