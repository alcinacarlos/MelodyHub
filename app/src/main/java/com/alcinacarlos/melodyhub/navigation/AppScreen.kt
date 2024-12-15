package com.alcinacarlos.melodyhub.navigation

sealed class AppScreen(val route: String) {
    object LoginScreen: AppScreen("LoginScreen")
    object SingInScreen : AppScreen("SingInScreen")
    object MainScreen : AppScreen("MainScreen")
    object InitialScreen: AppScreen("InitialScreen")
}