package com.vivekvishwanath.restmvvmdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vivekvishwanath.restmvvmdemo.R
import com.vivekvishwanath.restmvvmdemo.model.Recipe
import kotlin.math.roundToInt

class RecipeRecyclerAdapter(private val mOnRecipeListener: OnRecipeListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mRecipes = arrayListOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, mOnRecipeListener)
    }

    override fun getItemCount() = mRecipes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val requestOptions = RequestOptions().placeholder(
            R.drawable.ic_launcher_background)

        Glide
            .with(holder.itemView.context)
            .setDefaultRequestOptions(requestOptions)
            .load(mRecipes[position].image_url)
            .into((holder as RecipeViewHolder).image)

        holder.title.text = mRecipes[position].title
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