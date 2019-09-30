package com.vivekvishwanath.restmvvmdemo.requests

import com.vivekvishwanath.restmvvmdemo.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {

    companion object {
        private val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val recipeApi = retrofit.create(RecipeApi::class.java)
    }
}