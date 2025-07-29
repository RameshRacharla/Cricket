package com.ramesh.cricket.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramesh.cricket.data.localprefs.UserPreferences
import com.ramesh.cricket.data.repository.UserRepository
import com.ramesh.cricket.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val userRepository: UserRepository
) : ViewModel() {
    private val loading: MutableLiveData<Boolean> = MutableLiveData()

    fun addToken(token: String) {
        if (networkHelper.isNetworkConnected()) {
            loading.postValue(true)
            userRepository.saveAccessToken(token)
            loading.postValue(false)
        }

    }
}