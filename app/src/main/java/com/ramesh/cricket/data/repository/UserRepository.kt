package com.ramesh.cricket.data.repository

import com.ramesh.cricket.data.localprefs.UserPreferences
import com.ramesh.cricket.data.remote.NetworkService
import com.ramesh.cricket.data.remote.request.DataRequest
import com.ramesh.cricket.data.remote.response.CurrentMatchesResponse
import com.ramesh.cricket.data.remote.response.ScorecardDetailsResponse
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


    suspend fun getCurrentMatches(
        token: String, offset: Int
    ): Response<CurrentMatchesResponse> {
        return networkService.getCurrentMatches(
            token, offset
        )
    }

    suspend fun getScorecard(
        token: String, id: String
    ): Response<ScorecardDetailsResponse> {
        return networkService.getScorecard(
            token, id
        )
    }

}