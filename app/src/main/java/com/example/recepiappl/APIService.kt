package com.example.recepiappl

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()
interface APIService {
    @GET("categories.php")
    //this is a suspend function which will return the data of categories
    suspend fun getCategories(): CategoryResponse
}
val recepiService = retrofit.create(APIService::class.java)

