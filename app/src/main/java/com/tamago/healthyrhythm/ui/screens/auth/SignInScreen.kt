package com.tamago.healthyrhythm.ui.screens.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.data.repositories.auth.Resource
import com.tamago.healthyrhythm.ui.components.buttons.MainButton
import com.tamago.healthyrhythm.ui.components.textfields.EmailField
import com.tamago.healthyrhythm.ui.components.textfields.PasswordField
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction
import com.tamago.healthyrhythm.ui.theme.AppTheme

/**
 * Created by Igor Khoroshun on 06.12.2023.
 */

@Composable
fun SignInScreen(
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null
) {
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val signInFlow = viewModel.authManager
        .signInFlow
        .collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.medium_padding))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.medium_padding))
        ) {
            EmailField(
                value = email,
                onNewValue = {
                    email = it
                }
            )
            PasswordField(
                value = password,
                onNewValue = {
                    password = it
                }
            )
            MainButton(
                value = stringResource(R.string.sign_in),
                onClick = { viewModel.authManager.signIn(email, password) }
            )
            Row {
                TextButton(
                    onClick = {
                        navigationAction?.navigateToSignUp()
                    }
                ) {
                    Text(text = stringResource(R.string.no_account))
                }
                TextButton(
                    onClick = {
                        navigationAction?.navigateToResetPassword()
                    }
                ) {
                    Text(text = stringResource(R.string.forgot_password))
                }
            }
            signInFlow.value?.let {
                when (it) {
                    is Resource.Failure -> {
                        Toast.makeText(context, it.e.message, Toast.LENGTH_LONG).show()
                    }

                    Resource.Loading -> {
                        CircularProgressIndicator()
                    }

                    is Resource.Success -> {
                        LaunchedEffect(Unit) {
                            navigationAction?.navigateToMain()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview(
    viewModel: HealthyRhythmViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    AppTheme {
        SignInScreen(viewModel)
    }
}