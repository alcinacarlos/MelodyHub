package com.alcinacarlos.melodyhub

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.isToggleable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.*
import androidx.test.core.app.ApplicationProvider
import com.alcinacarlos.melodyhub.components.Email
import com.alcinacarlos.melodyhub.components.KeepLoggedInCheckbox
import com.alcinacarlos.melodyhub.components.LoginButton
import com.alcinacarlos.melodyhub.components.Password
import com.alcinacarlos.melodyhub.navigation.AppScreen
import com.alcinacarlos.melodyhub.screens.InitialScreen
import com.alcinacarlos.melodyhub.screens.LoginScreen
import com.alcinacarlos.melodyhub.screens.SignInScreen
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test


class TestsUI {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun emailField_showsErrorWhenInvalid() {
        val email = mutableStateOf("EMAIL")
        val emailError = mutableStateOf(false)
        val focusRequester = FocusRequester()

        composeTestRule.setContent {
            Email(
                email = email.value,
                emailError = emailError.value,
                onTextChanged = { email.value = it },
                focusRequester = focusRequester
            )
        }

        // Comprobar que el campo de texto está presente
        composeTestRule.onNodeWithText("EMAIL").assertIsDisplayed()

        // Simular ingreso de texto no válido
        composeTestRule.onNodeWithText("EMAIL").performTextInput("invalidemail")
        emailError.value = true

        // Comprobar que se muestra el mensaje de error
        composeTestRule.onNodeWithText("Introduce un emal válido").assertIsDisplayed()
    }

    @Test
    fun passwordField_showsErrorWhenInvalid() {
        val password = mutableStateOf("CONTRASEÑA")
        val isPasswordVisible = mutableStateOf(false)
        val passwordError = mutableStateOf(false)
        val focusRequester = FocusRequester()

        composeTestRule.setContent {
            Password(
                password = password.value,
                passwordError = passwordError.value,
                isPasswordVisible = isPasswordVisible.value,
                onPasswordVisibility = { isPasswordVisible.value = !isPasswordVisible.value },
                onTextChanged = { password.value = it },
                focusRequester = focusRequester
            )
        }

        // Comprobar que el campo de texto está presente
        composeTestRule.onNodeWithText("CONTRASEÑA").assertIsDisplayed()

        // Simular ingreso de texto no válido
        composeTestRule.onNodeWithText("CONTRASEÑA").performTextReplacement("1234")
        passwordError.value = true

        // Comprobar que se muestra el mensaje de error
        composeTestRule.onNodeWithText("La contraseña tiene que tener más de 6 caracteres").assertIsDisplayed()
    }

    @Test
    fun passwordField_togglePasswordVisibility() {
        val password = mutableStateOf("CONTRASEÑA")
        val isPasswordVisible = mutableStateOf(false)
        val passwordError = mutableStateOf(false)
        val focusRequester = FocusRequester()

        composeTestRule.setContent {
            Password(
                password = password.value,
                passwordError = passwordError.value,
                isPasswordVisible = isPasswordVisible.value,
                onPasswordVisibility = { isPasswordVisible.value = !isPasswordVisible.value },
                onTextChanged = { password.value = it },
                focusRequester = focusRequester
            )
        }

        // Comprobar que el campo de contraseña está presente
        composeTestRule.onNodeWithText("CONTRASEÑA").assertIsDisplayed()

        // Cambiar la visibilidad de la contraseña
        composeTestRule.onNodeWithContentDescription("Ocultar contraseña").performClick()

        // Verificar que se actualizó la visibilidad
        assert(isPasswordVisible.value)
    }

    @Test
    fun checkbox_updatesStateOnToggle() {
        val isChecked = mutableStateOf(false)
        val focusRequester = FocusRequester()

        composeTestRule.setContent {
            KeepLoggedInCheckbox(
                isChecked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                focusRequester = focusRequester
            )
        }

        // Comprobar que el checkbox está presente
        composeTestRule.onNodeWithText("Mantener sesión iniciada").assertIsDisplayed()

        // Alternar el estado del checkbox
        composeTestRule.onNode(isToggleable()).performClick()

        // Comprobar que el estado se actualizó
        assert(isChecked.value)
    }

    @Test
    fun loginButton_clickableOnlyWhenEnabled() {
        val isButtonEnabled = mutableStateOf(false)

        composeTestRule.setContent {
            LoginButton(
                onClick = {},
                enabled = isButtonEnabled.value
            )
        }

        // Verificar que el botón está deshabilitado inicialmente
        composeTestRule.onNodeWithContentDescription("Arrow").assertHasClickAction()
            .assertIsNotEnabled()

        // Habilitar el botón
        isButtonEnabled.value = true

        // Verificar que el botón está habilitado
        composeTestRule.onNodeWithContentDescription("Arrow").assertIsEnabled()
    }

    @Test
    fun navigationToCreateAccount() {
        // Configurar el TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.navigatorProvider.addNavigator(ComposeNavigator())
        val loginViewModel = LoginViewModel()
        // Renderizar el contenido de prueba
        composeTestRule.setContent {
            NavHost(navController = navController, startDestination = AppScreen.LoginScreen.route) {
                composable(AppScreen.LoginScreen.route) {
                    LoginScreen(navController, loginViewModel)
                }
                composable(AppScreen.SingInScreen.route) {
                    SignInScreen(navController, loginViewModel)
                }
            }
        }

        composeTestRule.onNodeWithText("Crear Cuenta").performClick()

        assertEquals(AppScreen.SingInScreen.route, navController.currentDestination?.route)

    }

    @Test
    fun initialScreen_horizontalPagerNext() {
        // Configurar el TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.navigatorProvider.addNavigator(ComposeNavigator())

        // Renderizar el contenido de prueba
        composeTestRule.setContent {
            NavHost(
                navController = navController,
                startDestination = AppScreen.InitialScreen.route
            ) {
                composable(AppScreen.InitialScreen.route) {
                    InitialScreen(navController = navController)
                }
            }
        }

        composeTestRule.onNodeWithContentDescription("Next Button").performClick()

        // Verifica que la navegación fue a la siguiente pantalla
        composeTestRule.onNodeWithText("Cada canción es un nuevo comienzo.").assertExists()
    }

    @Test
    fun initialScreen_horizontalPagerBack() {
        // Configurar el TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.navigatorProvider.addNavigator(ComposeNavigator())

        // Renderizar el contenido de prueba
        composeTestRule.setContent {
            NavHost(
                navController = navController,
                startDestination = AppScreen.InitialScreen.route
            ) {
                composable(AppScreen.InitialScreen.route) {
                    InitialScreen(navController = navController)
                }
            }
        }

        composeTestRule.onNodeWithContentDescription("Next Button").performClick()

        //primer boton de volver
        composeTestRule.onAllNodesWithContentDescription("Back Button")[0].performClick()

        // Verifica que la navegación fue a la siguiente pantalla
        composeTestRule.onNodeWithText("Escucha música con la mejor calidad en").assertExists()
    }

    @Test
    fun initialScreen_navigationToLast() {
        // Configurar el TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.navigatorProvider.addNavigator(ComposeNavigator())

        // Renderizar el contenido de prueba
        composeTestRule.setContent {
            NavHost(
                navController = navController,
                startDestination = AppScreen.InitialScreen.route
            ) {
                composable(AppScreen.InitialScreen.route) {
                    InitialScreen(navController = navController)
                }
            }
        }

        composeTestRule.onNodeWithText("Saltar").performClick()

        composeTestRule.onNodeWithText("Registrarse").assertExists()
    }

    @Test
    fun initialScreen_navigationToSignIn() {
        // Configurar el TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.navigatorProvider.addNavigator(ComposeNavigator())

        // Renderizar el contenido de prueba
        composeTestRule.setContent {
            NavHost(
                navController = navController,
                startDestination = AppScreen.InitialScreen.route
            ) {
                composable(AppScreen.InitialScreen.route) {
                    InitialScreen(navController = navController)
                }
                composable(AppScreen.SingInScreen.route) {
                    // Pantalla de registro
                }
            }
        }

        composeTestRule.onNodeWithText("Saltar").performClick()

        composeTestRule.onNodeWithText("Registrarse").performClick()

        assertEquals(AppScreen.SingInScreen.route, navController.currentDestination?.route)

    }
}