package com.example.healthyfood.data.remote

import com.example.healthyfood.data.remote.FoodService.RandomFoodService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomFoodRetrofitService {
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("x-api-key", "ad9748fefdbd44f48deebebf6770f9df")
                    .build()
            )
        }
    }.build()

    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.spoonacular.com/")
            .build()
    }

    fun getRandomFoodService(): RandomFoodService {
        return  getRetrofit().create(RandomFoodService::class.java)
    }
}