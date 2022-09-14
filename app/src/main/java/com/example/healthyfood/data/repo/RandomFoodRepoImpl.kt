package com.example.healthyfood.data.repo

import com.example.healthyfood.data.local.db.RandomFoodDao
import com.example.healthyfood.data.remote.FoodService.RandomFoodService
import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception

class RandomFoodRepoImpl(
    private val randomFoodService: RandomFoodService,
    private val randomFoodDao: RandomFoodDao
) : RandomFoodRepo {

    override suspend fun sendRequest() {
        val randomFoodResponse = randomFoodService.getRandomFood("10")
        if (randomFoodResponse.isSuccessful && randomFoodResponse.body() != null) {
            randomFoodResponse.body().let { recipe ->
                if (recipe != null) {
                    randomFoodDao.insertRecipe(recipe)
                }
            }
        }else {
            throw Exception("No Response")
        }
    }

    override fun getRandomFood(): Flow<ArrayList<RandomRecipeApiResponse>> {
        return randomFoodDao.getAllRandomFood()
    }
}