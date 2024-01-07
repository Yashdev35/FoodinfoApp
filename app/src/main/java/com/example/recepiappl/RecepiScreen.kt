package com.example.recepiappl

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecepiScreen(modifier: Modifier = Modifier,
                 navigateToDetail: (Category) -> Unit,
                 viewState : MainViewModel.RecipeState) {
    Box (
        modifier = Modifier.fillMaxSize()
    ){
       /*in this when block either we are processing the data or we are displaying the data or we are displaying the error
        and each case will have a different ui*/
        when{
            viewState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "ERROR")
            }
            else -> {
                //display the list of categories
                categoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}
//creating a composable for the grid which will display the categories
@Composable
fun categoryScreen(categories: List<Category>, navigateToDetail: (Category) -> Unit) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
      items(categories){
          /*the following piece of code says that for each individual item execute the following code
          execute the following code for each category form the list of categories*/
          categorY ->
            CategoryItem(category = categorY , navigateToDetail)
      }
        }
    }
//creating a composable for recipe item
@Composable
fun CategoryItem(category: Category, navigateToDetail: (Category) -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize().clickable {
            navigateToDetail(category)
        }
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        if (category.idCategory == "1"){
            Image(
                painter = rememberAsyncImagePainter(null),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().padding(2.dp).aspectRatio(1f)
            )
            Text(
                text = "NO BEEF",
                color = colorResource(id = R.color.teal_200),
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(4.dp)
                    .padding(top = 4.dp)
            )
        }else {
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().padding(2.dp).aspectRatio(1f)
            )
            Text(
                text = category.strCategory,
                color = colorResource(id = R.color.teal_200),
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(4.dp)
                    .padding(top = 4.dp)
            )
        }
    }
}