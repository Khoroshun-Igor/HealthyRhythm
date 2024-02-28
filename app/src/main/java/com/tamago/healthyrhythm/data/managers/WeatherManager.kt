package com.tamago.healthyrhythm.data.managers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.healthyrhythm.app.ApiKey
import com.tamago.healthyrhythm.data.models.WeatherMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 19.02.2024.
 */
//class WeatherManager @Inject constructor(
//    private val weatherService: WeatherService
//): ViewModel() {
//
//    var weather: WeatherMain = WeatherMain(0.0)
//
//    fun getWeather(lat: String, lon: String) = viewModelScope.launch(Dispatchers.IO) {
//        val weatherData = weatherService.getWeather(lat, lon, ApiKey.API_KEY)
//        weather = weatherData
//    }
//}