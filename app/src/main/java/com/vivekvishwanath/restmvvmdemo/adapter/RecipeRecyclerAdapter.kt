package com.vivekvishwanath.restmvvmdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vivekvishwanath.restmvvmdemo.R
import com.vivekvishwanath.restmvvmdemo.model.Recipe
import kotlinx.android.synthetic.main.layout_recipe_list_item.view.*
import kotlin.math.roundToInt

class RecipeRecyclerAdapter(val mRecipes: ArrayList<Recipe>, private val mOnRecipeListener: OnRecipeListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, mOnRecipeListener)
    }

    override fun getItemCount() = mRecipes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecipeViewHolder).title.text = mRecipes[position].title
        holder.publisher.text = mRecipes[position].publisher
        holder.socialScore.text = "${mRecipes[position].social_rank.roundToInt()}"
    }

    fun setRecipes(newRecipes: List<Recipe>) {
        val diffCallback = RecipeDiffCallback(mRecipes, newRecipes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        mRecipes.clear()
        mRecipes.addAll(newRecipes)
        diffResult.dispatchUpdatesTo(this)
    }

}