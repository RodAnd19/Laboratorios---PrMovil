package com.example.laboratorio11.network.dto.register



data class RegisterRequest (
    // Campos requeridos para realizar la petición del register.
    val name : String,
    val email : String,
    val password : String
    )
