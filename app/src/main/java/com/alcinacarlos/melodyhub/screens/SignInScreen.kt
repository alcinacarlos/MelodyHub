package com.alcinacarlos.melodyhub.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alcinacarlos.melodyhub.components.signin.BodySignIn
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel

@Composable
fun SignInScreen(navController: NavController, loginViewModel: LoginViewModel) {
    BodySignIn(
        loginViewModel = loginViewModel,
        navController = navController
    )
}
