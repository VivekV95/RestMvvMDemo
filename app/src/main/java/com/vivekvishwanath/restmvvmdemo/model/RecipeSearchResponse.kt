package com.vivekvishwanath.restmvvmdemo.model

class RecipeSearchResponse(
    val count: Int,
    val recipes: MutableList<Recipe>
) {

    override fun toString(): String {
        return "RecipeSearchResponse(count=$count, " +
                "recipes=$recipes)"
    }
}