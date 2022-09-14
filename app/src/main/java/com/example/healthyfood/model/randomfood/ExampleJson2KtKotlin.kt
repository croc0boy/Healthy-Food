package com.example.example

import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlin(

    @SerializedName("recipes") val recipes: ArrayList<Recipes>

)