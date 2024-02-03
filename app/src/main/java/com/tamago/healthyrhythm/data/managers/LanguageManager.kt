package com.tamago.healthyrhythm.data.managers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tamago.healthyrhythm.data.sharedprefs.SharedPrefs
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */
class LanguageManager @Inject constructor(private val sharedPrefs: SharedPrefs) {
    private val _language = mutableStateOf(sharedPrefs.loadLanguage())
    val language: State<String> = _language

    fun select (language: Language): Boolean{
        return if(language.nameString != _language.value){
            _language.value = language.nameString
            sharedPrefs.saveLanguage(_language.value)
            true
        }else false
    }

    enum class Language(val nameString: String){
        RU("ru"), EN("en")
    }

    companion object{
        fun getLanguage(local: String) = when(local){
            Language.RU.nameString -> Language.RU
            Language.EN.nameString -> Language.EN
            else -> Language.EN
        }
    }
}