package com.alcinacarlos.melodyhub.navigation

import androidx.compose.runtime.Composable
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.alcinacarlos.melodyhub.screens.InitialScreen
import com.alcinacarlos.melodyhub.screens.LoginScreen
import com.alcinacarlos.melodyhub.screens.MainScreen
import com.alcinacarlos.melodyhub.screens.SignInScreen
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel


@Composable
fun AppNavigation(exoPlayer: ExoPlayer){
    val navControlador = rememberNavController()
    val loginViewModel = LoginViewModel()

    NavHost(navController = navControlador, startDestination = AppScreen.InitialScreen.route) {
        composable(AppScreen.InitialScreen.route){
            InitialScreen(navControlador)
        }

        composable(AppScreen.MainScreen.route){
            MainScreen(loginViewModel, exoPlayer)
        }

        composable(AppScreen.LoginScreen.route){
            LoginScreen(navControlador, loginViewModel)
        }

        composable(AppScreen.SingInScreen.route){
            SignInScreen(navControlador, loginViewModel)
        }

    }
}