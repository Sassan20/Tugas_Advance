package com.test.tugasadvancetim.data.remote.retrofit

import com.test.tugasadvancetim.data.remote.response.ResponseTeam
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("tim")
    suspend fun getTeam(
        @Query("id") id: Int = 1
    ): ResponseTeam
}