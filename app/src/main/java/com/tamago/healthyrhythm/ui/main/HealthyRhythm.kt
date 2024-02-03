package com.tamago.healthyrhythm.ui.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavGraph

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

@Composable
fun HealthyRhythm(){
    val viewModel: HealthyRhythmViewModel = viewModel()

    AppNavGraph(viewModel = viewModel)
}