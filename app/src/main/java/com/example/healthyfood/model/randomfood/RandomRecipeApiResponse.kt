package com.example.healthyfood.model.randomfood

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.example.Recipes
import com.google.gson.annotations.SerializedName


@Entity(tableName = "food_recipe")
data class RandomRecipeApiResponse(
    @ColumnInfo(name = "recipes")
    @SerializedName("recipes")
    val recipes: ArrayList<Recipes>
)
