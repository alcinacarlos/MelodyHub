package com.alcinacarlos.melodyhub.components.initial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.components.BackButton
import com.alcinacarlos.melodyhub.components.PageIndicator
import com.alcinacarlos.melodyhub.navigation.AppScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun InitialBody(pagerState: PagerState, coroutineScope: CoroutineScope, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black))
    ) {
        BackButton(pagerState, coroutineScope)
        PageIndicator(pagerState)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IntialCentered()
            LoginRegisterButtons(
                iniciarSesion = { navController.navigate(route = AppScreen.LoginScreen.route) },
                registrarse = { navController.navigate(route = AppScreen.SingInScreen.route) }
            )
        }
    }
}

@Composable
fun IntialCentered() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagenLogo(R.drawable.logo2)
        InitialText()
        InitialText2()
    }
}

@Composable
fun InitialText() {
    Text(
        text = stringResource(R.string.welcome),
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = colorResource(R.color.white),
        modifier = Modifier.padding(top = 20.dp, start = 30.dp)
    )
}
@Composable
fun InitialText2() {
    Text(
        text = stringResource(R.string.enter),
        fontSize = 18.sp,
        color = colorResource(R.color.white),
        modifier = Modifier.padding(top = 20.dp, start = 30.dp)
    )
}

@Composable
fun LoginRegisterButtons(iniciarSesion : () -> Unit, registrarse : () -> Unit) {
    Column(
        modifier = Modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón de Iniciar sesión
        Button(
            onClick = { iniciarSesion() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.naranja))
        ) {
            Text(
                text = "Iniciar sesion",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
        }

        // Botón de Registrarse
        Button(
            onClick = { registrarse() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.naranja))
        ) {
            Text(
                text = "Registrarse",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
        }
    }
}