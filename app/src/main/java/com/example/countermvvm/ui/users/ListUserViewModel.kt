package com.example.countermvvm.ui.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countermvvm.data.datasource.jsonPlaceholderService
import com.example.countermvvm.model.user.User
import kotlinx.coroutines.launch
import retrofit2.Response

class ListUserViewModel : ViewModel() {
    private val _listUserState = mutableStateOf(ListUserState())
    val listUserState: State<ListUserState> = _listUserState

    init {
        fetchListUser()
    }

    private fun fetchListUser() {
        viewModelScope.launch {
            try {
                val res = jsonPlaceholderService.getUsers()
                _listUserState.value = _listUserState.value.copy(
                    loading = false,
                    error = null,
                    listUser = res.body() ?: emptyList()
                )
            } catch (e: Exception) {
                println(e.message)
                _listUserState.value = _listUserState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }


    data class ListUserState(
        val loading: Boolean = true,
        val listUser: List<User> = emptyList(),
        val error: String? = null
    )
}