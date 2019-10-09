package com.vivekvishwanath.restmvvmdemo.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vivekvishwanath.restmvvmdemo.R

class RecipeViewHolder(itemView: View, val onRecipeListener: OnRecipeListener): RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val title = itemView.findViewById<TextView>(R.id.recipe_title)
    val publisher = itemView.findViewById<TextView>(R.id.recipe_publisher)
    val socialScore = itemView.findViewById<TextView>(R.id.recipe_social_score)
    val image = itemView.findViewById<ImageView>(R.id.recipe_image)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onRecipeListener.onRecipeClick(adapterPosition)
    }

}