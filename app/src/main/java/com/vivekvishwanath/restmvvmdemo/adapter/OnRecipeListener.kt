package com.vivekvishwanath.restmvvmdemo.adapter

interface OnRecipeListener {

    fun onRecipeClick(position: Int)

    fun onCategoryClick(category: String)
}