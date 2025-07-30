package com.ramesh.cricket.data.remote.response

import com.google.gson.annotations.SerializedName


data class ScorecardDetailsResponse(
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val list: DataList? = null
)