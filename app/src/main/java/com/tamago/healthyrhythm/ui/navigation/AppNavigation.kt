package com.tamago.healthyrhythm.ui.navigation

import androidx.navigation.NavHostController

/**
 * Created by Igor Khoroshun on 03.12.2023.
 */

object AppNavDestination{
    const val MAIN_ROUTE = "main"
    const val SIGN_UP_ROUTE = "sign_up"
    const val SIGN_IN_ROUTE = "sign_in"
    const val RESET_PASSWORD_ROUTE = "reset_password"
    const val SETTING_ROUTE = "setting"
}

class AppNavigationAction(private val navController: NavHostController) {
    fun back(){
        if(navController.previousBackStackEntry != null){
            navController.popBackStack()
        }
    }
    fun navigateToMain(){
        navController.navigate(AppNavDestination.MAIN_ROUTE){
            popUpTo(AppNavDestination.MAIN_ROUTE)
            launchSingleTop = true
            restoreState = true
        }
    }
    fun navigateToSignUp(){
        navController.navigate(AppNavDestination.SIGN_UP_ROUTE){
            launchSingleTop = true
            restoreState = true
        }
    }
    fun navigateToSignIn(){
        navController.navigate(AppNavDestination.SIGN_IN_ROUTE){
            launchSingleTop = true
            restoreState = true
        }
    }
    fun navigateToResetPassword(){
        navController.navigate(AppNavDestination.RESET_PASSWORD_ROUTE){
            launchSingleTop = true
            restoreState = true
        }
    }
    fun navigateToSettingScreen(){
        navController.navigate(AppNavDestination.SETTING_ROUTE){
            launchSingleTop = true
            restoreState = true
        }
    }
}