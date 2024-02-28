package com.tamago.healthyrhythm.ui.components.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.data.managers.LanguageManager
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

@Composable
fun TopBar(
    currentLanguage: LanguageManager.Language,
    onSwitchLangAction: (LanguageManager.Language) -> Unit,
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
    ){
        Column(
            modifier = modifier
                .padding(dimensionResource(R.dimen.medium_padding))
        ) {
            LanguageSwitcher(
                currentLanguage = currentLanguage,
                onSwitchLangAction = onSwitchLangAction
            )
        }

        Spacer(modifier = modifier.weight(1f))
        Column(
            modifier = modifier
                .padding(dimensionResource(R.dimen.medium_padding))
        ) {
            AccountMenu(
                viewModel = viewModel,
                navigationAction = navigationAction
            )
        }
    }
}