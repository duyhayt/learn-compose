package com.example.countermvvm.model.login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Objects

data class LoginResponse(
    val header: Objects,
    val body: LoginData,
    val statusCodeValue: Int,
    val statusCode: String
)

data class LoginData(
    val access_token: String,
    val expires_in: Long,
    val refresh_expires_in: Long,
    val refresh_token: String,
    val token_type: String,
    val id_token: String?,
    val not_before_policy: Long,
    val session_state: String?,
    val scope: String?,
    val error: String?,
    val error_description: String?,
    val error_uri: String?
)