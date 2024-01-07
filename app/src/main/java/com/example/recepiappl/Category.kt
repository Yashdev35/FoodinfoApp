package com.example.recepiappl

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//this is a data class which will hold the data of category
@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
): Parcelable
/*
serializations and deserialization is done by parcelize, it will convert the data into bytes and then send it to the api
or to destination and then it will convert the bytes into data, parcelize the category to make it easy to send it to other places
/*above will create a object of category which will hold the data of category
now to get the data from api we will create another data class, this will data of categories(list of categories)

 */
*/
data class CategoryResponse(
    val categories: List<Category>
)