package com.ramesh.cricket.data.remote.request

import com.google.gson.annotations.SerializedName


data class DataRequest(
    @field:SerializedName("Message")
    val message: String? = null
)