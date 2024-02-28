package com.tamago.healthyrhythm.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Igor Khoroshun on 12.02.2024.
 */

@Serializable
data class WeatherMain(
    @SerialName("temp")
    val value: Double
)

@Serializable
data class Weather(
    @SerialName("icon")
    val icon: String
)
