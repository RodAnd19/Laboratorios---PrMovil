package com.example.laboratorio11.network.dto.login

import com.google.gson.annotations.SerializedName


data class LoginResponse (
    // Esta es la estructura de la respuesta recibida de nuestra API al momento de realizar el inicio de sesión.
    @SerializedName("msg") val message : String,
    @SerializedName("token") val token : String
    )