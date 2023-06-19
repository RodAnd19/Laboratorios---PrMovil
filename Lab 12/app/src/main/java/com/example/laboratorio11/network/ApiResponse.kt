package com.example.laboratorio11.network

import java.lang.Exception

sealed class ApiResponse<T> {

    // Representa una respuesta exitosa de la API.
    data class Succes<T>(val data : T) : ApiResponse<T>()

    // Representa una respuesta de error de la API.
    data class Error<T>(val exception : Exception) : ApiResponse<T>()

    // Representa una respuesta de error de la API, pero incluye un mensage descriptivo del porque del error.
    data class ErrorWithMessage<T>(val message : String) : ApiResponse<T>()

}