package com.example.countermvvm.data.datasource

import com.example.countermvvm.domain.Environment
import com.example.countermvvm.model.recipe.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl(Environment.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiServices::class.java)


interface ApiServices {
    @GET("categories.php")
    suspend fun getCategories(
    ): CategoriesResponse
}