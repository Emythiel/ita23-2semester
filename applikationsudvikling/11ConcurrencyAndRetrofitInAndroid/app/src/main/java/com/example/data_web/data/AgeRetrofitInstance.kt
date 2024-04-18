package com.example.data_web.data

import com.example.data_web.network.AgifyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AgeRetrofitInstance {
    private val baseURL = "https://api.agify.io";

    val retrofitClient = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofitClient.create(AgifyApi::class.java)
}
