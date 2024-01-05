package com.example.recepiappl

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//this will be our main view model cuz we are using MVVM architecture
class MainViewModel : ViewModel() {
    //creating a data class to know if the suspended function has provided us with the data or not
    data class RecipeState(
        val Loading: Boolean = false,
        val list: List<Category> = emptyList(),
        val error: String? = null// when we dont have an error it is set to null
    )

     private val _categoryState = mutableStateOf(RecipeState())//this will hold the state of our recipe
    //the above varible is private so we will create a public variable to access it
    val categoryState: State<RecipeState> = _categoryState//this will be used to get the state of our recipe
    //this will be use to update the ui when state changes

    //creating a function to get the data from api
    private fun fetchCategories(){
        //we will use viewModelScope, it provides a launch for suspending function to be process
        //we have to start a suspend function is coroutine scope
        viewModelScope .launch {
            try{

            }catch (e: Exception){
                _categoryState.value = _categoryState.value.copy(
                    Loading = false,
                    error = " error occured while fetching the categories ${e.localizedMessage}"
                )
            }
        }
    }


}