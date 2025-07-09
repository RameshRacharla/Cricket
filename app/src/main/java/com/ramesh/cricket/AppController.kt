package com.ramesh.cricket

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */

@HiltAndroidApp
class AppController : Application()
{
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}