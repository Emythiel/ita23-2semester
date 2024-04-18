package com.example.data_web.network

import com.example.data_web.DTO.CatFact
import retrofit2.http.GET

interface CatFactsApi {
    @GET("/fact")
    suspend fun getFact(): CatFact
}
