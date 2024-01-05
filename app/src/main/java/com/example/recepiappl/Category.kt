package com.example.recepiappl
//this is a data class which will hold the data of category
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)
//above will create a object of category which will hold the data of category
//now to get the data from api we will create another data class, this will data of categories(list of categories)

data class CategoryResponse(
    val categories: List<Category>
)