package com.tamago.healthyrhythm.ui.screens.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.ui.components.animation.Loader
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.settings),
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.medium_padding))
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = stringResource(id = R.string.table_of_norms),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = dimensionResource(R.dimen.medium_padding))
                        .size(dimensionResource(R.dimen.avatar_size))
                )
            }
            SettingCard(
                text = stringResource(R.string.rhythm_of_breath),
                res = R.raw.rythm_of_breath
            )
            SettingCard(
                text = stringResource(R.string.time),
                res = R.raw.timer
            )
            SettingCard(
                text = stringResource(R.string.options),
                res = R.raw.options
            )
            MainButton(
                value = stringResource(R.string.start), onClick = { /*TODO*/ })
        }
    }
}