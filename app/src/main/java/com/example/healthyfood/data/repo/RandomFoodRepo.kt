package com.example.healthyfood.data.repo

import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse
import kotlinx.coroutines.flow.Flow

interface RandomFoodRepo {

    suspend fun sendRequest()

   fun getRandomFood(): Flow<ArrayList<RandomRecipeApiResponse>>
}