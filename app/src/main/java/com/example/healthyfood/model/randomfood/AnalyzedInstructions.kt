package com.example.example

import com.google.gson.annotations.SerializedName


data class AnalyzedInstructions(

    @SerializedName("name") val name: String,
    @SerializedName("steps") val steps: ArrayList<Steps>

)