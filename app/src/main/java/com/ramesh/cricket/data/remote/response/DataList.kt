package com.ramesh.cricket.data.remote.response

import com.google.gson.annotations.SerializedName


data class DataList(
    @field:SerializedName("id")
    val id: String? = "",

    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("matchType")
    val matchType: String? = "",

    @field:SerializedName("status")
    val status: String? = "",

    @field:SerializedName("venue")
    val venue: String? = "",

    @field:SerializedName("date")
    val date: String? = "",

    @field:SerializedName("teamInfo")
    val teamInfo: List<TeamInfo?>? = emptyList(),

    @field:SerializedName("score")
    val score: List<Score?>? = emptyList(),

    @field:SerializedName("tossWinner")
    val tossWinner: String? = "",

    @field:SerializedName("tossChoice")
    val tossChoice: String? = "",

    @field:SerializedName("scorecard")
    val scorecard: List<Scorecard?>? = emptyList(),
)

data class TeamInfo(
    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("shortname")
    val shortname: String? = "",

    @field:SerializedName("img")
    val img: String? = "",
)

data class Score(
    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("shortname")
    val shortname: String? = "",

    @field:SerializedName("img")
    val img: String? = "",
)

data class Score1(
    val name: String,
    val shortname: String,
    val img: String
)

data class Scorecard(
    @field:SerializedName("batting")
    val batting: List<Batting?>? = emptyList(),

    @field:SerializedName("bowling")
    val bowling: List<Bowling?>? = emptyList()
)

data class Batting(
    @field:SerializedName("name")
    val name: String? = ""
)

data class Bowling(
    @field:SerializedName("name")
    val name: String? = ""
)
