package com.andres.lab04

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Valores en pantalla
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        val emailTextView = findViewById<TextView>(R.id.email_text_view)
        val numberTextView = findViewById<TextView>(R.id.number_text_view)

        val shareButton = findViewById<Button>(R.id.share_button)

        // Valores externos
        val showNameText = intent.getStringExtra("nombre")
        val showEmailText = intent.getStringExtra("correo")
        val showNumberText = intent.getStringExtra("numero")

        // Mostrar valores en los Text View
        nameTextView.text = "Nombre: $showNameText"
        emailTextView.text = "Correo electrónico: $showEmailText"
        numberTextView.text = "Número: $showNumberText"

        // COMPARTIR INFORMACIÓN
        shareButton.setOnClickListener {
            // Crear el intent
            val shareIntent = Intent(Intent.ACTION_SEND)

            // Colocar valores en el intent
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Name: $showNameText/nEmail: $showEmailText/nPhone: $showNumberText")

            // Iniciar la actividad con la información de el intent con un Chooser
            startActivity(Intent.createChooser(shareIntent,"Share to:"))
        }

    }
}