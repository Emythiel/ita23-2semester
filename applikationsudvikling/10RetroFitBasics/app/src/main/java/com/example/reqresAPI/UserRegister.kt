package com.example.reqresAPI

import com.google.gson.annotations.SerializedName

data class UserRegister(
    @SerializedName("email") val email: String?,
    @SerializedName("password") val password: String?
)
