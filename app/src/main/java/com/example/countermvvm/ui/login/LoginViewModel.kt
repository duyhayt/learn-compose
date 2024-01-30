package com.example.countermvvm.ui.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.countermvvm.data.datasource.LoginRequest
import com.example.countermvvm.data.datasource.loginService
import com.example.countermvvm.model.login.LoginData
import com.example.countermvvm.navigation.NavigationScreen
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {
    private val _loginSate = mutableStateOf(LoginSate())
    val loginSate: State<LoginSate> = _loginSate
    fun login(email: String, password: String) {
        println("Start")
        val loginRequest = LoginRequest(email, password)
        viewModelScope.launch {
            try {
                val res = loginService.login(loginRequest)
                _loginSate.value = _loginSate.value.copy(
                    email = email,
                    password = password,
                    loading = false,
                    loginSuccessfully = true,
                    loginData = res.body,
                    loginError = null
                )
                println(_loginSate.value.loginData)
            } catch (e: Exception) {
                println(e.message)
                _loginSate.value = _loginSate.value.copy(
                    loading = false,
                    loginError = e.message
                )
            }
        }
    }

    data class LoginSate(
        var email: String = "",
        var password: String = "",
        val loading: Boolean = true,
        val loginSuccessfully: Boolean = false,
        val loginData: LoginData? = null,
        val loginError: String? = null
    )
}