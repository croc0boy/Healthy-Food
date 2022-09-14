package com.example.example

import com.google.gson.annotations.SerializedName


data class Ingredients(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("localizedName") val localizedName: String,
    @SerializedName("image") val image: String

)