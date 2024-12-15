package com.alcinacarlos.melodyhub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.alcinacarlos.melodyhub.screens.InitialScreen
import com.alcinacarlos.melodyhub.screens.LoginScreen
import com.alcinacarlos.melodyhub.screens.MainScreen
import com.alcinacarlos.melodyhub.screens.SignInScreen
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel


@Composable
fun AppNavigation(){
    val navControlador = rememberNavController()
    val loginViewModel = LoginViewModel()

    NavHost(navController = navControlador, startDestination = AppScreen.MainScreen.route) {
        composable(AppScreen.InitialScreen.route){
            InitialScreen(navControlador)
        }

        composable(AppScreen.MainScreen.route){
            MainScreen(navControlador, loginViewModel)
        }

        composable(AppScreen.LoginScreen.route){
            LoginScreen(navControlador, loginViewModel)
        }

        composable(AppScreen.SingInScreen.route){
            SignInScreen(navControlador, loginViewModel)
        }

    }
}