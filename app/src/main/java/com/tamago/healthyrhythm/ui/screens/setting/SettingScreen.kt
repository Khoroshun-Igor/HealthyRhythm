package com.tamago.healthyrhythm.ui.screens.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.ui.components.buttons.MainButton
import com.tamago.healthyrhythm.ui.components.settingcard.SettingCard
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction

/**
 * Created by Igor Khoroshun on 28.01.2024.
 */

@Composable
fun SettingScreen(
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column {
            Text(
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            SettingCard(
                text = stringResource(R.string.rhythm_of_breath),
                image = Icons.Default.Home
            )
            SettingCard(
                text = stringResource(R.string.time),
                image = Icons.Default.Home
            )
            SettingCard(
                text = stringResource(R.string.options),
                image = Icons.Default.Home
            )
            MainButton(
                value = stringResource(R.string.start), onClick = { /*TODO*/ })
        }
    }
}