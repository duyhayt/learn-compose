package com.example.countermvvm.navigation

sealed class NavigationScreen(val route: String) {
    data object LoginScreen : NavigationScreen("login")
    data object RecipeScreen : NavigationScreen("recipe")
    data object DetailScreen : NavigationScreen("detail")
    data object ListUserScreen : NavigationScreen("listUser")
}