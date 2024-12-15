package com.alcinacarlos.melodyhub.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alcinacarlos.melodyhub.components.main.MainBody
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel

@Composable
fun MainScreen(navController: NavController, loginViewModel: LoginViewModel) {
    MainBody(loginViewModel)
}