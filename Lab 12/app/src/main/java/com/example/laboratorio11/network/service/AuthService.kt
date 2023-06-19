package com.example.laboratorio11.network.service

import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.dto.login.LoginResponse
import com.example.laboratorio11.network.dto.register.RegisterRequest
import com.example.laboratorio11.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    // Sera el metodo para enviar información del Inicio de Sesión.
    @POST("api/auth/login")
    suspend fun login(@Body credentials : LoginRequest) : LoginResponse

    // Sera el metodo para enviar información del Registro.
    @POST("api/auth/register")
    suspend fun register(@Body credentials : RegisterRequest) : RegisterResponse
}