package com.example.boredAPI

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredApi {
    @GET("/api/activity")
    suspend fun getTask(
    ): BoredTask

    @GET("/api/activity")
    suspend fun getTaskParticipants(
        @Query("participants") participants: Int?
    ): BoredTask

    @GET("/api/activity")
    suspend fun getTaskAccessibilityPrice(
        @Query("minaccessibility") minaccessibility: Double?,
        @Query("maxaccessibility") maxaccessibility: Double?,
        @Query("minprice") minprice: Double?,
        @Query("maxprice") maxprice: Double?
    ): BoredTask
}
