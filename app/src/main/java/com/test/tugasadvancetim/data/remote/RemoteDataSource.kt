package com.test.tugasadvancetim.data.remote

import com.test.tugasadvancetim.data.remote.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTeam() = apiService.getTeam()
}