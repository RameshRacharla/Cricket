package com.ramesh.cricket.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramesh.cricket.data.remote.response.CurrentMatchesResponse
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
class MainViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val userRepository: UserRepository,
) : ViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val xAuth = userRepository.getAccessToken()
    val getCurrentMatchesResponse: MutableLiveData<Resource<CurrentMatchesResponse>> =
        MutableLiveData()
    private val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    fun getCurrentMatches() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                loading.postValue(true)

                val response = userRepository.getCurrentMatches(
                    xAuth!!, 0
                )
                if (response.isSuccessful) {
                    getCurrentMatchesResponse.postValue(Resource.success(response.body()))
                } else {
                    messageString.postValue(Resource.error(response.body()?.status.toString()))
                }
                loading.postValue(false)
            }
        }
    }
}