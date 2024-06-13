package com.test.tugasadvancetim.data.remote.response

import com.google.gson.annotations.SerializedName

data class TeamItemResponse(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("longitude")
	val longitude: Double
)
