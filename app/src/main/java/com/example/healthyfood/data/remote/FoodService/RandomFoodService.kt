package com.example.healthyfood.data.remote.FoodService

import com.example.example.Recipes
import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomFoodService {
    @GET("recipes/random")
    suspend fun getRandomFood(@Query("number") number: String): Response<RandomRecipeApiResponse>

}