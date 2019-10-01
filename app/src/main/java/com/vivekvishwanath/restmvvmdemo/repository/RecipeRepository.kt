package com.vivekvishwanath.restmvvmdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vivekvishwanath.restmvvmdemo.model.Recipe

class RecipeRepository {

    var mRecipes: MutableLiveData<List<Recipe>>? = null

    companion object {
        var instance: RecipeRepository? = null
            private set
            get() {
                if (field == null) instance = RecipeRepository()
                return field
            }
    }

    init {
        mRecipes = MutableLiveData()
    }

    fun getRecipes(): LiveData<List<Recipe>>? {
        return mRecipes
    }
}
