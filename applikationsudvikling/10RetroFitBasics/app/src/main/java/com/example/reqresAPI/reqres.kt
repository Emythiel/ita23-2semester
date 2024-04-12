package com.example.reqresAPI

import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

fun main() {
    exerciseA2()
    //exerciseB2()
}

fun exerciseA2() {
    runBlocking {
        val api = RetrofitInstance()
        val user = UserRegister("eve.holt@reqres.in", "");

        val response = api.apiService.registerUser(user).awaitResponse()
        println(response.body()?.string())

        /*val response = api.apiService.registerUser(user).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println(response.body()?.string())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
        })*/
    }
}

fun exerciseB2() {
    runBlocking {
        val api = RetrofitInstance()
        val user = UserRegister("eve.holt@reqres.in", "saf");

        val response = api.apiService.loginUser(user).awaitResponse()
        println(response.body()?.string())

        /*val response = api.apiService.registerUser(user).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println(response.body()?.string())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
        })*/
    }
}
