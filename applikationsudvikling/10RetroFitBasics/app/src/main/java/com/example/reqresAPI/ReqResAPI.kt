package com.example.reqresAPI

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReqResAPI {
    @Headers("Content-Type: application/json")
    @POST("register")
    fun registerUser(@Body user: UserRegister): Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @POST("login")
    fun loginUser(@Body user: UserRegister): Call<ResponseBody>
}
