package com.example.healthyfood.util.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthyfood.data.local.db.RandomFoodDB
import com.example.healthyfood.data.remote.RandomFoodRetrofitService
import com.example.healthyfood.data.repo.RandomFoodRepo
import com.example.healthyfood.data.repo.RandomFoodRepoImpl
import com.example.healthyfood.domain.GetRandomFoodUseCase
import com.example.healthyfood.domain.SendRequestUseCase
import com.example.healthyfood.ui.fragments.home.vm.HomeViewModel
import retrofit2.Retrofit

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val randomFoodRepo = RandomFoodRepoImpl(
            RandomFoodRetrofitService.getRandomFoodService(),
            RandomFoodDB.getDatabaseInstance().getDao()
        )
        return HomeViewModel(
            GetRandomFoodUseCase(randomFoodRepo),
            SendRequestUseCase(randomFoodRepo)
        ) as T
    }
}