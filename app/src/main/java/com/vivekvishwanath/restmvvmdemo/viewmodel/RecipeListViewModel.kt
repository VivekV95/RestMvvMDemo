package com.vivekvishwanath.restmvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vivekvishwanath.restmvvmdemo.model.Recipe
import com.vivekvishwanath.restmvvmdemo.repository.RecipeRepository

class RecipeListViewModel: ViewModel() {
    private var mRecipeRepository: RecipeRepository? = null

    init {
        mRecipeRepository = RecipeRepository()
    }

    fun getRecipes(): LiveData<List<Recipe>>? {
        return mRecipeRepository?.getRecipes()
    }

}