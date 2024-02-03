package com.tamago.healthyrhythm.data.sharedprefs

import android.content.SharedPreferences
import com.tamago.healthyrhythm.app.Constants

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */
class SharedPrefs(private val sharedPrefs: SharedPreferences) {

    fun saveLanguage(value: String) = sharedPrefs.edit().putString(LANGUAGE, value).apply()

    fun loadLanguage(): String{
        return sharedPrefs.getString(LANGUAGE, null) ?: Constants.DEFAULT_LANGUAGE
    }

    companion object{
        private const val LANGUAGE = Constants.LANGUAGE
    }
}