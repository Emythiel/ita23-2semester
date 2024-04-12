package com.example.catfact

import retrofit2.http.GET

interface CatFactsApi {
    @GET("/fact")
    suspend fun getFact(
    ): CatFact
}