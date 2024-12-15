package com.alcinacarlos.melodyhub.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled = _isLoginEnabled

    private val _emailError = MutableLiveData<Boolean>()
    val emailError = _emailError

    private val _passwordError = MutableLiveData<Boolean>()
    val passwordError = _passwordError

    private val _isPasswordVisible = MutableLiveData<Boolean>()
    val isPasswordVisible = _isPasswordVisible

    private val _rememberLogin = MutableLiveData<Boolean>()
    val rememberLogin = _rememberLogin

    fun changeRemeberLogin(){
        _rememberLogin.value = _rememberLogin.value != true
    }

    fun onEmailChanged(email: String) {

        if (email.length > 20) return

        _email.value = email.trim()


        val isValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        _emailError.value = !isValid

        enableLogin()
    }


    fun onPasswordChanged(password: String){
        _password.value = password.trim()

        val isValid = password.isNotBlank() && password.length > 6

        _passwordError.value = !isValid

        enableLogin()
    }

    fun changePasswordVisibility(){
        _isPasswordVisible.value = _isPasswordVisible.value != true
    }


    fun enableLogin(){
        if (_passwordError.value == false && _emailError.value == false){
            _isLoginEnabled.value = true
        }else{
            _isLoginEnabled.value = false
        }
    }
}