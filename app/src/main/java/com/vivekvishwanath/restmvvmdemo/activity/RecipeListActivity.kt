package com.vivekvishwanath.restmvvmdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vivekvishwanath.restmvvmdemo.R
import com.vivekvishwanath.restmvvmdemo.adapter.OnRecipeListener
import com.vivekvishwanath.restmvvmdemo.adapter.RecipeRecyclerAdapter
import com.vivekvishwanath.restmvvmdemo.model.Recipe
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
    var count = 1
    private var recipeAdapter = RecipeRecyclerAdapter(arrayListOf(Recipe("Blalala",
        "feff", "efewgg", 5f, listOf("fef"), "ee")), object : OnRecipeListener {
        override fun onRecipeClick(position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onCategoryClick(category: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    })

    private var mRecipeListViewModel: RecipeListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)
        subscribeObservers()

        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@RecipeListActivity)
            adapter = recipeAdapter
        }

        test.setOnClickListener {
            searchRecipesApi("chicken breast", count++)
        }
    }

    private fun subscribeObservers() {
        mRecipeListViewModel?.getRecipes()?.observe(this, Observer {
            recipeAdapter.setRecipes(it)
        } )
    }

    private fun searchRecipesApi(query: String, pageNumber: Int) {
        mRecipeListViewModel?.searchRecipesApi(query, pageNumber)
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
