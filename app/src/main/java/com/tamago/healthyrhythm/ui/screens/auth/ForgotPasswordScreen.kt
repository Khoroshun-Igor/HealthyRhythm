package com.tamago.healthyrhythm.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.ui.components.bottomnavmenu.BottomNavMenu
import com.tamago.healthyrhythm.ui.components.textfields.EmailField
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction

/**
 * Created by Igor Khoroshun on 24.01.2024.
 */

@Composable
fun ForgotPasswordScreen(
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null
){
    var email by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailField(
                    value = email,
                    onNewValue = {
                        email = it
                    }
                )
                Button(
                    onClick = { viewModel.authManager.resetEmail(email) }
                ) {
                    Text(stringResource(R.string.reset))
                }
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
        ) {
            BottomNavMenu(
                navigationAction = navigationAction
            )
        }
    }
}