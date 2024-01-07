package com.example.recepiappl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecepiApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoryState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecepiScreen(navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                /*
                in the above code we made the category class parcelable so that we can send it to the detail screen
                any other generic data type can be sent without making it parcelable but for custom data type we have to
                make it parcelable so that set can use it
                 */
                navController.navigate(Screen.DetailScreen.route)
            }, viewState = viewState)
        }
        composable(route = Screen.DetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")?:Category(
                    "0",
                    "name",
                    "",
                    "description"
                )
           if(category.idCategory == "1"){
               val dummyCategory = Category(
                   "1",
                   "NO BEEF SON",
                   "",
                   "I dont like beef so i wont put that here"
               )
                CategoryScreen(category = dummyCategory)
           }else{
               CategoryScreen(category = category)
           }

        }

    }
}
