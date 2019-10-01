package com.vivekvishwanath.restmvvmdemo.model

class RecipeSearchResponse(
    val count: Int,
    val recipes: List<Recipe>
) {

    override fun toString(): String {
        return "RecipeSearchResponse(count=$count, " +
                "recipes=$recipes)"
    }
}