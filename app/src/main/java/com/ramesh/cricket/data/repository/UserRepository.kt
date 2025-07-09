package com.ramesh.cricket.data.repository

import com.ramesh.cricket.data.localprefs.UserPreferences
import com.ramesh.cricket.data.remote.NetworkService
import com.ramesh.cricket.data.remote.request.DataRequest
import com.ramesh.cricket.data.remote.response.DataResponse
import retrofit2.Response
import javax.inject.Inject

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */

class UserRepository @Inject constructor(
    private val networkService: NetworkService, private val userPreferences: UserPreferences
) {

    fun saveAccessToken(token: String) {
        userPreferences.setAccessToken(token)
    }

    fun getAccessToken(): String? {
        return userPreferences.getAccessToken()
    }


    suspend fun getData(
        Authorization: String, str: String
    ): Response<DataResponse> {
        return networkService.getData(
            Authorization, DataRequest(str)
        )
    }


}