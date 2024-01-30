package com.example.countermvvm.data.datasource

import com.example.countermvvm.domain.Environment
import com.example.countermvvm.model.login.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private val retrofit = Retrofit.Builder().baseUrl(Environment.SCA_SERVER)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val loginService: LoginService = retrofit.create(LoginService::class.java)

interface LoginService {
    @POST("user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}

data class LoginRequest(
    val username: String,
    val password: String
)