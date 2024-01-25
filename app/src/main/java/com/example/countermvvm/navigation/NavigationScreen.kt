package com.example.countermvvm.navigation

sealed class NavigationScreen(val route: String) {
    object RecipeScreen: NavigationScreen("recipescreen")
    object DetailScreen: NavigationScreen("detailscreen")
    object ListUserScreen: NavigationScreen("listUserScreen")
}