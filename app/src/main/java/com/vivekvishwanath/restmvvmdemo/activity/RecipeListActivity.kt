package com.vivekvishwanath.restmvvmdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vivekvishwanath.restmvvmdemo.R
import com.vivekvishwanath.restmvvmdemo.model.RecipeResponse
import com.vivekvishwanath.restmvvmdemo.model.RecipeSearchResponse
import com.vivekvishwanath.restmvvmdemo.requests.ServiceGenerator
import com.vivekvishwanath.restmvvmdemo.util.Constants
import com.vivekvishwanath.restmvvmdemo.viewmodel.RecipeListViewModel
import kotlinx.android.synthetic.main.activity_recipe_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeListActivity : BaseActivity() {
    companion object {
        const val TAG = "RecipeListActivity"
    }

    private var mRecipeListViewModel: RecipeListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)

    }

    fun subscribeObservers() {
        mRecipeListViewModel?.getRecipes()?.observe(this, Observer {

        } )
    }

    /* fun testRetrofitRequest() {
        val recipeApi = ServiceGenerator.recipeApi

        val responseCall = recipeApi.getRecipe(Constants.API_KEY, "8c0314")
        responseCall.enqueue(object: Callback<RecipeResponse>{
            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<RecipeResponse>,
                response: Response<RecipeResponse>
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }*/
}
