package com.alcinacarlos.melodyhub.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alcinacarlos.melodyhub.components.login.BodyLogin
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {
    BodyLogin(
        loginViewModel = loginViewModel,
        navController = navController
    )
}
