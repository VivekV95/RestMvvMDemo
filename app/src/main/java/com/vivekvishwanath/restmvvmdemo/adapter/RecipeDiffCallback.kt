package com.vivekvishwanath.restmvvmdemo.adapter

import androidx.recyclerview.widget.DiffUtil
import com.vivekvishwanath.restmvvmdemo.model.Recipe

class RecipeDiffCallback(private val oldList: List<Recipe>, private val newList: List<Recipe>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].recipe_id == newList[newItemPosition].recipe_id
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return !(oldList[oldItemPosition].title != newList[newItemPosition].title ||
                oldList[oldItemPosition].image_url != newList[newItemPosition].image_url ||
                oldList[oldItemPosition].ingredients != newList[newItemPosition].ingredients ||
                oldList[oldItemPosition].publisher != newList[newItemPosition].publisher ||
                oldList[oldItemPosition].social_rank != newList[newItemPosition].social_rank)
    }

}