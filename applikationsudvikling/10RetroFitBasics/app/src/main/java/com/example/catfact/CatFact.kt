package com.example.catfact

import com.google.gson.annotations.SerializedName

data class CatFact(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)