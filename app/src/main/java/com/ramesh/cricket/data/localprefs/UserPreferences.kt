package com.ramesh.cricket.data.localprefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */

@Singleton
class UserPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, "")

    fun setAccessToken(token: String) = prefs.edit { putString(KEY_ACCESS_TOKEN, token) }

    fun clearData() {
        prefs.edit {
            clear()
        }
    }
}