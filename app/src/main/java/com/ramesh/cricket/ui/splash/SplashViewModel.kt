package com.ramesh.cricket.ui.splash

import androidx.lifecycle.ViewModel
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
    networkHelper: NetworkHelper, private val userRepository: UserRepository
) : ViewModel() {


}