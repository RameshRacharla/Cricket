package com.ramesh.cricket.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramesh.cricket.data.remote.response.DataResponse
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
    private val networkHelper: NetworkHelper, private val userRepository: UserRepository
) : ViewModel() {

}