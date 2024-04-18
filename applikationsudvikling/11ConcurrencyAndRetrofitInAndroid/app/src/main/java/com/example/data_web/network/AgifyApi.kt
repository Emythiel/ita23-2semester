package com.example.data_web.network

import com.example.data_web.DTO.AgifyData
import retrofit2.http.GET
import retrofit2.http.Query

interface AgifyApi {
    @GET("/")
    suspend fun getAge(
        @Query("name") name: String
    ): AgifyData
}
