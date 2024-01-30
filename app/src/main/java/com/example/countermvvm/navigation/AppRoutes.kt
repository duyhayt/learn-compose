package com.example.countermvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.countermvvm.model.recipe.Category
import com.example.countermvvm.ui.login.LoginScreen
import com.example.countermvvm.ui.recipe.DetailScreen
import com.example.countermvvm.ui.recipe.RecipeScreen
import com.example.countermvvm.ui.users.ListUserScreen

@Composable
fun AppScreen(navController: NavHostController, modifier: Modifier) { //quản lý điều hướng trong ứng dụng
    NavHost(navController = navController, startDestination = NavigationScreen.LoginScreen.route) {
        composable(route = NavigationScreen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = NavigationScreen.RecipeScreen.route) {
            RecipeScreen(navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    "cat",
                    it
                ) //đặt category là có tên là cat và value là it(1 đối tượng Category)
                navController.navigate(NavigationScreen.DetailScreen.route)
            })
        }

        composable(route = NavigationScreen.DetailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category(
                        "",
                        "",
                        "",
                        ""
                    ) //Trích xuất giá trị đối tượng Category từ màn hình trước
            DetailScreen(navController = navController, category = category)
        }
        composable(route = NavigationScreen.ListUserScreen.route) {
            ListUserScreen()
        }

    }


//    NavHost(navController = navController, startDestination = NavigationScreen.RecipeScreen.route) {
//        composable(route = NavigationScreen.RecipeScreen.route) {
//            RecipeScreen(viewState = viewState, navigateToDetail = {
//                navController.currentBackStackEntry?.savedStateHandle?.set(
//                    "cat",
//                    it
//                ) //đặt category là có tên là cat và value là it(1 đối tượng Category)
//                navController.navigate(NavigationScreen.DetailScreen.route)
//            })
//        }
//
//        composable(route = NavigationScreen.DetailScreen.route) {
//            val category =
//                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
//                    ?: Category(
//                        "",
//                        "",
//                        "",
//                        ""
//                    ) //Trích xuất giá trị đối tượng Category từ màn hình trước
//            DetailScreen(navController = navController, category = category)
//        }
//        composable(route = NavigationScreen.ListUserScreen.route) {
//            ListUserScreen()
//        }
//
//    }
}

