package com.andres.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.andres.laboratorio05.R
import com.andres.laboratorio05.data.model.MovieModel
import com.google.android.material.textfield.TextInputEditText

class CreateMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var name: EditText
    private lateinit var category: EditText
    private lateinit var description: EditText
    private lateinit var calification: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind(view)
        submitButton.setOnClickListener {
            createMovie()
        }
    }
    // Funciones a utilizar.
    private fun bind (view: View) {
        name = view.findViewById(R.id.name_il)
        category = view.findViewById(R.id.category_il)
        description = view.findViewById(R.id.description_il)
        calification = view.findViewById(R.id.calification_il)
        submitButton = view.findViewById(R.id.submit_btn)
    }

    private fun createMovie () {
        val newMovie = MovieModel(
            name.text.toString(),
            category.text.toString(),
            description.text.toString(),
            calification.text.toString()
        )
        viewModel.addMovies(newMovie)

        Log.d("APP TAG", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }
}