package com.test.tugasadvancetim.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseTeam(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("results")
    val results: List<TeamItemResponse>
)
