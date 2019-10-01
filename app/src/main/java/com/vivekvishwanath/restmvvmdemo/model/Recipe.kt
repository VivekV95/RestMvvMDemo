package com.vivekvishwanath.restmvvmdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Recipe(
    val title: String,
    val publisher: String,
    val image_url: String,
    val social_rank: Float,
    val ingredients: List<String>,
    val recipe_id: String
): Parcelable {

    override fun toString(): String {
        return "Recipe(title='$title'," +
                " publisher='$publisher'," +
                " image_url='$image_url'," +
                " social_rank=$social_rank, " +
                "ingredients=$ingredients," +
                " recipe_id='$recipe_id')"
    }
}

class RecipeResponse(val recipe: Recipe) {

    override fun toString(): String {
        return "RecipeResponse(recipe=$recipe)"
    }
}