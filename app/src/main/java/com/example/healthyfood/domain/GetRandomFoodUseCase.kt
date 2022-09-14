package com.example.healthyfood.domain

import com.example.healthyfood.data.repo.RandomFoodRepo
import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse


class GetRandomFoodUseCase (private val randomFoodRepo: RandomFoodRepo) {
   fun execute(): kotlinx.coroutines.flow.Flow<ArrayList<RandomRecipeApiResponse>> {
        return randomFoodRepo.getRandomFood()
    }
}