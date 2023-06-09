package com.example.laboratorio11.network.dto.login


data class LoginRequest (
    // Aca iran los campos que se requieren al realizar la petición del inicio de sesión.
    val email : String,
    val password : String
)