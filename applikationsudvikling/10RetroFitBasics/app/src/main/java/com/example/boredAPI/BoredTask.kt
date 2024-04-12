package com.example.boredAPI

import com.google.gson.annotations.SerializedName

data class BoredTask(
    @SerializedName("activity")
    val activity: String,
    @SerializedName("accessibility")
    val accessibility: Double?,
    @SerializedName("type")
    val type: String,
    @SerializedName("participants")
    val participants: Int,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("link")
    val link: String,
    @SerializedName("key")
    val key: Int
)
