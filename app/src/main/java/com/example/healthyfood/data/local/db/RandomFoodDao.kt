package com.example.healthyfood.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface RandomFoodDao {

    @Query("SELECT * FROM food_recipe")
    fun getAllRandomFood(): Flow<ArrayList<RandomRecipeApiResponse>>

    @Insert
    suspend fun insertRecipe(randomRecipeApiResponse: RandomRecipeApiResponse)
}