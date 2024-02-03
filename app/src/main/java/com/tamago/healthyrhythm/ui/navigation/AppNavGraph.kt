package com.tamago.healthyrhythm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tamago.healthyrhythm.ui.main.HealthyRhythmViewModel
import com.tamago.healthyrhythm.ui.screens.auth.ForgotPasswordScreen
import com.tamago.healthyrhythm.ui.screens.auth.SignInScreen
import com.tamago.healthyrhythm.ui.screens.auth.SignUpScreen
import com.tamago.healthyrhythm.ui.screens.main.MainScreen
import com.tamago.healthyrhythm.ui.screens.setting.SettingScreen

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */
@Composable
fun AppNavGraph(
    viewModel: HealthyRhythmViewModel,
    startDestination: String = AppNavDestination.MAIN_ROUTE
) {
    val navController = rememberNavController()
    val navigationAction = remember(navController){
        AppNavigationAction(navController)
    }

    NavHost(navController = navController, startDestination = startDestination){
        composable(route = AppNavDestination.MAIN_ROUTE){
            MainScreen(viewModel, navigationAction)
        }
        composable(route = AppNavDestination.SIGN_UP_ROUTE){
            SignUpScreen(viewModel, navigationAction)
        }
        composable(route = AppNavDestination.SIGN_IN_ROUTE){
            SignInScreen(viewModel, navigationAction)
        }
        composable(route = AppNavDestination.RESET_PASSWORD_ROUTE){
            ForgotPasswordScreen(viewModel, navigationAction)
        }
        composable(route = AppNavDestination.SETTING_ROUTE){
            SettingScreen(viewModel, navigationAction)
        }
    }
}