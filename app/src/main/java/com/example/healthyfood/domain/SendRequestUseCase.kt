package com.example.healthyfood.domain

import com.example.healthyfood.data.repo.RandomFoodRepo

class SendRequestUseCase (private val randomFoodRepo: RandomFoodRepo) {
    suspend fun execute() {
        randomFoodRepo.sendRequest()
    }
}