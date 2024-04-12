package com.example.reqresPOSTexample

import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

fun main() {
    runBlocking {
        val api = RetrofitInstance()
        val user = User(1, "Morpheus");

        val response = api.apiService.addUser(user).awaitResponse()
        println(response.body()?.string())
    }

    //Below is one way of handling the response concurrently by the retrofit framework

    /*
    val response = api.apiService.addUser(user).enqueue(object : Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            println(response.body()?.string())
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        }
    })
    */
}