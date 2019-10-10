package com.vivekvishwanath.restmvvmdemo.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vivekvishwanath.restmvvmdemo.R
import com.vivekvishwanath.restmvvmdemo.adapter.OnRecipeListener
import com.vivekvishwanath.restmvvmdemo.adapter.RecipeRecyclerAdapter
import com.vivekvishwanath.restmvvmdemo.viewmodel.RecipeListViewModel
import kotlinx.android.synthetic.main.activity_recipe_list.*


class RecipeListActivity : BaseActivity(), OnRecipeListener {

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCategoryClick(category: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val TAG = "RecipeListActivity"
    }

    private var recipeAdapter: RecipeRecyclerAdapter? = null

    private var mRecipeListViewModel: RecipeListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)
        subscribeObservers()

        initRecyclerView()

        test.setOnClickListener {
            searchRecipesApi("chicken breast", 1)
        }
    }

    private fun initRecyclerView() {
        recipeAdapter = RecipeRecyclerAdapter(this)
        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@RecipeListActivity)
            adapter = recipeAdapter
        }
    }

    private fun subscribeObservers() {
        mRecipeListViewModel?.getRecipes()?.observe(this, Observer {recipes ->
            recipes?.let {
                recipeAdapter?.setRecipes(it)
            }
        } )
    }

    private fun searchRecipesApi(query: String, pageNumber: Int) {
        mRecipeListViewModel?.searchRecipesApi(query, pageNumber)
    }

}
