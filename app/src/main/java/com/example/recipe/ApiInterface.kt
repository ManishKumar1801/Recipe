package com.example.recipe

import com.example.recipe.models.RecipesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("recipes/complexSearch")
    fun getRecipeData(@Query("number") number:Int,@Query("apiKey") apiKey:String): Call<RecipesList>
}