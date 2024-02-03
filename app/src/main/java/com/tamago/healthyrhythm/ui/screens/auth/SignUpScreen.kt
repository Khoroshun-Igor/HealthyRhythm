package com.tamago.healthyrhythm.ui.screens.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.tamago.healthyrhythm.R
import com.tamago.healthyrhythm.data.repositories.auth.Resource
import com.tamago.healthyrhythm.ui.components.buttons.MainButton
import com.tamago.healthyrhythm.ui.components.textfields.EmailField
import com.tamago.healthyrhythm.ui.components.textfields.NameField
import com.tamago.healthyrhythm.ui.components.textfields.PasswordField
import com.tamago.healthyrhythm.ui.components.textfields.RepeatPasswordField
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.navigation.AppNavigationAction
import com.tamago.healthyrhythm.utils.isValidEmail
import com.tamago.healthyrhythm.utils.isValidPassword
import com.tamago.healthyrhythm.utils.passwordMatches

/**
 * Created by Igor Khoroshun on 06.12.2023.
 */

@Composable
fun SignUpScreen(
    viewModel: HealthyRhythmViewModel,
    navigationAction: AppNavigationAction? = null,
    modifier: Modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
){
    val context = LocalContext.current

    val signUpFlow = viewModel.authManager
        .signUpFlow
        .collectAsState()

    var message = ""

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var repeatPassword by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            NameField(
                value = name,
                onNewValue = {
                    name = it
                }
            )
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
            RepeatPasswordField(
                value = repeatPassword,
                onNewValue = {
                    repeatPassword = it
                }
            )
            MainButton(
                value = stringResource(R.string.sign_up),
                onClick = {
                    when{
                        !email.isValidEmail() -> message = "Email isn't valid"
                        !password.isValidPassword() -> message = "Password isn't valid"
                        !password.passwordMatches(repeatPassword) -> message = "Passwords aren't match"
                    }

                    if(message == ""){
                        viewModel.authManager.signUp(name, email, password)
                    } else{
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                    }
                }
            )
            Row{
                TextButton(onClick = { navigationAction?.navigateToSignIn() }) {
                    Text(stringResource(R.string.already_user))
                }
            }
            signUpFlow.value?.let {
                when(it){
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