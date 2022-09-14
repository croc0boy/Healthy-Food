package com.example.healthyfood.data.local.db

import androidx.room.*
import com.example.healthyfood.model.randomfood.RandomRecipeApiResponse
import com.example.healthyfood.util.App

@Database(entities = [RandomRecipeApiResponse::class], version = 1)
abstract class RandomFoodDB : RoomDatabase() {

    abstract fun getDao(): RandomFoodDao

    companion object {
        private var INSTANCE: RandomFoodDB? = null

        fun getDatabaseInstance(): RandomFoodDB {
            return INSTANCE ?: Room.databaseBuilder(
                App.getContext(),
                RandomFoodDB::class.java,
                "food_db"
            ).fallbackToDestructiveMigration()
                .build().also {
                    INSTANCE = it
                }
        }
    }
}