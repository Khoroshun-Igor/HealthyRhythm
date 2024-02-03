package com.tamago.healthyrhythm.data.repositories

import com.tamago.healthyrhythm.data.managers.AuthManager
import com.tamago.healthyrhythm.data.managers.LanguageManager
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

class AppRepository @Inject constructor(
    val languageManager: LanguageManager,
    val authManager: AuthManager
)