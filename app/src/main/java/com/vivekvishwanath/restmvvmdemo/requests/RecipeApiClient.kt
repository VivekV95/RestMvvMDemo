package com.vivekvishwanath.restmvvmdemo.requests

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vivekvishwanath.restmvvmdemo.activity.RecipeListActivity.Companion.TAG
import com.vivekvishwanath.restmvvmdemo.model.Recipe
import com.vivekvishwanath.restmvvmdemo.model.RecipeSearchResponse
import com.vivekvishwanath.restmvvmdemo.threading.AppExecutors
import com.vivekvishwanath.restmvvmdemo.util.Constants.API_KEY
import com.vivekvishwanath.restmvvmdemo.util.Constants.NETWORK_TIMEOUT
import retrofit2.Call
import java.util.concurrent.TimeUnit

class RecipeApiClient {

    var mRecipes: MutableLiveData<MutableList<Recipe>>? = null
        private set
    private var mRetrieveRecipesRunnable: RetrieveRecipesRunnable? = null

    init {
        mRecipes = MutableLiveData()
    }

    companion object {
        var instance: RecipeApiClient? = null
            private set
            get() {
                if (field == null) instance = RecipeApiClient()
                return field
            }
    }

    fun searchRecipesApi(query: String, pageNumber: Int) {
        mRetrieveRecipesRunnable = RetrieveRecipesRunnable(query, pageNumber)
        val handler = AppExecutors.instance?.mNetworkIO?.submit(mRetrieveRecipesRunnable)

        AppExecutors.instance?.mNetworkIO?.schedule(Runnable {
            // Let the user know it's timed out
            handler?.cancel(true)
        }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
    }

    private inner class RetrieveRecipesRunnable(
        val query: String,
        val pageNumber: Int,
        var cancelRequest: Boolean = false
    ) : Runnable {
        override fun run() {
            val response = getRecipes(query, pageNumber).execute()
            if (cancelRequest) return
            if (response.code() == 200) {
                val list = response.body()?.recipes
                if (pageNumber == 1) mRecipes?.postValue(list)
                else {
                    val currentRecipes = mRecipes?.value
                    list?.let { currentRecipes?.addAll(it) }
                    mRecipes?.postValue(currentRecipes)
                }
            } else {
                val error = response.errorBody()?.string()
                Log.e(TAG, "run: $error")
                mRecipes?.postValue(null)
            }
        }

        private fun getRecipes(query: String, pageNumber: Int): Call<RecipeSearchResponse> {
            return ServiceGenerator.recipeApi.searchRecipe(API_KEY, query, "$pageNumber")
        }

        private fun cancelRequest() {
            Log.d(TAG, "cancelRequest: cancelling the search request")
            cancelRequest = true
        }
    }
}