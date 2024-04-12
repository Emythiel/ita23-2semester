package com.example.reqresPOSTexample

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReqResAPIExample {
    @Headers("Content-Type: application/json")
    @POST("user")
    fun addUser(@Body userData: User): Call<ResponseBody>
}
