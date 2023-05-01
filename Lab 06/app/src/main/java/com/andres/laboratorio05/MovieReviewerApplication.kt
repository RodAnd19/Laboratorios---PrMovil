package com.andres.laboratorio05

import android.app.Application
import com.andres.laboratorio05.data.movies
import com.andres.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication : Application() {

    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}