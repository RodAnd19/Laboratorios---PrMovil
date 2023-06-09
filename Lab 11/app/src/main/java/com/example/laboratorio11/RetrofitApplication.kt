package com.example.laboratorio11

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.laboratorio11.network.retrofit.RetrofitInstance
import com.example.laboratorio11.network.service.AuthService
import com.example.laboratorio11.repository.CredentialsRepository

class RetrofitApplication : Application() {

    // Almacena y recupera datos de forma persistente dentro de la app.
    private val prefs : SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    private fun getAPIService () = with(RetrofitInstance) {
        setToken(getToken())
        getLoginService()
    }

    fun getToken () : String = prefs.getString(USER_TOKEN, "")!!

    val credentialsRepository : CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    fun saveAutoToken (token : String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}