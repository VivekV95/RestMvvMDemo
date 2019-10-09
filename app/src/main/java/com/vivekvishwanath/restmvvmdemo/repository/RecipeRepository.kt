package com.vivekvishwanath.restmvvmdemo.repository

import androidx.lifecycle.LiveData
import com.vivekvishwanath.restmvvmdemo.model.Recipe
import com.vivekvishwanath.restmvvmdemo.requests.RecipeApiClient

class RecipeRepository {

    private var mRecipeApiClient: RecipeApiClient? = null

    init {
        mRecipeApiClient = RecipeApiClient.instance
    }

    companion object {
        var instance: RecipeRepository? = null
            private set
            get() {
                if (field == null) instance = RecipeRepository()
                return field
            }
    }

    fun getRecipes(): LiveData<MutableList<Recipe>>? {
        return mRecipeApiClient?.mRecipes
    }

    fun searchRecipesApi(query: String, pageNumber: Int) {
        val page = if (pageNumber == 0) 1 else pageNumber
        mRecipeApiClient?.searchRecipesApi(query, page)
    }
}
