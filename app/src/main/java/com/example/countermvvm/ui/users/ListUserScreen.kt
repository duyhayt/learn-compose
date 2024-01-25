package com.example.countermvvm.ui.users

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.countermvvm.model.user.User

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListUserScreen() {
    val listUserViewModel: ListUserViewModel = viewModel()
    when {
        listUserViewModel.listUserState.value.loading -> {
            CircularProgressIndicator()
        }

        listUserViewModel.listUserState.value.error != null -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "ERROR OCCURRED")
            }
        }

        else -> {
            ListUser(users = listUserViewModel.listUserState.value.listUser)
        }
    }
}

@Composable
fun ListUser(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            UserItem(user = user)
        }
    }
}

@Composable
fun UserItem(user: User) {
    // Giao diện của một mục trong danh sách người dùng
    Text(text = "Name: ${user.name}", style = MaterialTheme.typography.subtitle1)
    Text(text = "Name: ${user.address.street}", style = MaterialTheme.typography.subtitle2)
}