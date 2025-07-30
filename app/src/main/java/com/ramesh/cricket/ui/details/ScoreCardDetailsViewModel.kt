package com.ramesh.cricket.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramesh.cricket.data.remote.response.ScorecardDetailsResponse
import com.ramesh.cricket.data.repository.UserRepository
import com.ramesh.cricket.utils.common.Resource
import com.ramesh.cricket.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
@HiltViewModel
class ScoreCardDetailsViewModel @Inject constructor(
    private val networkHelper: NetworkHelper, private val userRepository: UserRepository
) : ViewModel() {
    val xAuth = userRepository.getAccessToken()
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val getDataResponse: MutableLiveData<Resource<ScorecardDetailsResponse>> = MutableLiveData()
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    fun getScorecardDetails(id: String) = viewModelScope.launch {
        if (networkHelper.isNetworkConnected()) {
            loading.postValue(true)

            val response = userRepository.getScorecard(xAuth!!, id)
            if (response.isSuccessful) {
                getDataResponse.postValue(Resource.success(response.body()))
            } else {
                messageString.postValue(Resource.error(response.body()?.status.toString()))
            }
            loading.postValue(false)
        }
    }


}