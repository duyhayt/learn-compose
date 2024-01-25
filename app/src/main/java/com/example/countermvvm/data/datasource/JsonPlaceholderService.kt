package com.example.countermvvm.data.datasource

import com.example.countermvvm.domain.Environment
import com.example.countermvvm.model.user.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl(Environment.JSON_PLACE_HOLDER)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val jsonPlaceholderService: JsonPlaceholderService = retrofit.create(JsonPlaceholderService::class.java)

interface JsonPlaceholderService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}