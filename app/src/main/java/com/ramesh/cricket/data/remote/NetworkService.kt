package com.ramesh.cricket.data.remote

import com.ramesh.cricket.data.remote.response.CurrentMatchesResponse
import retrofit2.Response
import retrofit2.http.*

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
interface NetworkService {

    @POST(Endpoints.CurrentMatches)
    suspend fun getCurrentMatches(
        @Query("apikey") token: String, @Query("Offset") offset: Int
    ): Response<CurrentMatchesResponse>

}
