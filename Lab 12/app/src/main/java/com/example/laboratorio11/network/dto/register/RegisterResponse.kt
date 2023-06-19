package com.example.laboratorio11.network.dto.register

import com.google.gson.annotations.SerializedName


data class RegisterResponse (
    // Esta es la estructura de la respuesta recibida de nuestra API al momento de realizar el register.
    @SerializedName("msg") val message : String
    )
