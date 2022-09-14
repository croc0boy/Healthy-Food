package com.example.healthyfood.ui.fragments.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfood.domain.GetRandomFoodUseCase
import com.example.healthyfood.domain.SendRequestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getRandomFoodUseCase: GetRandomFoodUseCase,
    private val sendRequestUseCase: SendRequestUseCase
) : ViewModel() {

    fun sendRequest() = viewModelScope.launch(Dispatchers.IO) {
        sendRequestUseCase.execute()
    }

    fun getRandomFood() = getRandomFoodUseCase.execute()

}