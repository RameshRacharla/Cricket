package com.ramesh.cricket.data.remote

import com.ramesh.cricket.data.remote.Endpoints
import com.ramesh.cricket.data.remote.request.DataRequest
import com.ramesh.cricket.data.remote.response.DataResponse
import retrofit2.Response
import retrofit2.http.*

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
interface NetworkService {

    @POST(Endpoints.CricScore)
    suspend fun getData(
        @Header("Authorization") token: String, @Body request: DataRequest
    ): Response<DataResponse>

}
