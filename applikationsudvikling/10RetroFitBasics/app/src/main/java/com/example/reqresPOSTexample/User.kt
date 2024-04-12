package com.example.reqresPOSTexample

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("user_name") val userName: String?
)