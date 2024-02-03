package com.tamago.healthyrhythm.ui.screens.main

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.data.managers.LanguageManager
import com.tamago.healthyrhythm.ui.components.buttons.MainButton
import com.tamago.healthyrhythm.ui.components.topbar.TopBar
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction
import com.tamago.healthyrhythm.ui.theme.AppTheme

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

@Composable
fun MainScreen(
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    val currentLanguage = LanguageManager.getLanguage(viewModel.languageManager.language.value)
    val onSwitchManager: (LanguageManager.Language) -> Unit = { language ->
        if(viewModel.languageManager.select(language)){
            if(context is Activity)
                context.recreate()
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onBackground)
        ) {
            TopBar(
                currentLanguage,
                onSwitchManager,
                viewModel,
                navigationAction = navigationAction
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row {
                Title()
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
        ) {
            MainButton(
                value = stringResource(R.string.start),
                onClick = { navigationAction?.navigateToSettingScreen() }
            )
        }
    }
}

@Composable
fun Title(){
    Text(
        text = stringResource(R.string.title),
        style = MaterialTheme.typography.displayLarge,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Preview
@Composable
fun TitlePreview(){
    AppTheme {
        Title()
    }
}