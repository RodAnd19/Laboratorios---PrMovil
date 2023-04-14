package com.andres.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definición de elementos
        val nameEditText = findViewById<EditText>(R.id.name_text_field)
        val emailEditText = findViewById<EditText>(R.id.email_text_field)
        val numberEditText = findViewById<EditText>(R.id.number_text_field)
        val saveButton = findViewById<Button>(R.id.save_button)

        saveButton.setOnClickListener {
            val nameValue = nameEditText.text.toString()
            val emailValue = emailEditText.text.toString()
            val numberValue = numberEditText.text.toString()

            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra("nombre", nameValue) // Aca se guardaran y se mandaran mediante un intent los valores que se guardaron.
            secondActivityIntent.putExtra("correo", emailValue)
            secondActivityIntent.putExtra("numero", numberValue)
            startActivity(secondActivityIntent)
        }
    }
}