package com.vivekvishwanath.restmvvmdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vivekvishwanath.restmvvmdemo.model.Recipe
import com.vivekvishwanath.restmvvmdemo.requests.RecipeApiClient

class RecipeRepository {

    private var recipeApiClient: RecipeApiClient? = null

    init {
        recipeApiClient = RecipeApiClient.instance
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
        return recipeApiClient?.mRecipes
    }
}
