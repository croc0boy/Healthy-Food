package com.example.example

import com.google.gson.annotations.SerializedName


data class Metric(

    @SerializedName("amount") val amount: Int,
    @SerializedName("unitShort") val unitShort: String,
    @SerializedName("unitLong") val unitLong: String

)