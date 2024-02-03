package com.tamago.healthyrhythm.ui.main

import androidx.lifecycle.ViewModel
import com.tamago.healthyrhythm.data.repositories.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */
@HiltViewModel
class HealthyRhythmViewModel @Inject constructor(appRepository: AppRepository) : ViewModel() {
    val languageManager = appRepository.languageManager
    val authManager = appRepository.authManager
}