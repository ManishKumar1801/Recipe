package com.example.recipe.models

data class RecipesList(
    val number: Int,
    val offset: Int,
    val results: List<Results>,
    val totalResults: Int
)