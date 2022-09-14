package com.example.example

import com.google.gson.annotations.SerializedName


data class Steps(

    @SerializedName("number") val number: Int,
    @SerializedName("step") val step: String,
    @SerializedName("ingredients") val ingredients: ArrayList<Ingredients> ,
    @SerializedName("equipment") val equipment: ArrayList<Equipment>

)