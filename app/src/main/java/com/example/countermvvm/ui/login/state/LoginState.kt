package com.example.countermvvm.ui.login.state

//import com.example.countermvvm.ui.common.state.ErrorState

data class LoginState(
    val email: String = "",
    val password: String = "",
    val errorState: String = "Login error",
    val isLoginSuccessful: Boolean = false
)
