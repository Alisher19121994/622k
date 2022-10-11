package com.example.a622k.managers

import android.content.Context
import android.content.SharedPreferences
import com.example.a622k.SignIn
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferenceManagerss(context: Context) {

    private var sharedPreferences: SharedPreferences?

    init {
        sharedPreferences = context.getSharedPreferences(
            "MyPrefs", Context.MODE_PRIVATE)
    }

    companion object {
        private var preferenceManager: PreferenceManagerss? = null
        fun getInstance(context: Context): PreferenceManagerss? {
            if (preferenceManager == null) {
                preferenceManager = PreferenceManagerss(context)
            }
            return preferenceManager
        }
    }


    fun saveDate(signIn: SignIn) {
        val editor = sharedPreferences?.edit()
        val gson = Gson()
        val json = gson.toJson(signIn)
        editor?.putString("text",json)
        editor?.apply()
    }

}