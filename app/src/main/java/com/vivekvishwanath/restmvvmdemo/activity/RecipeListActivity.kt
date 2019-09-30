package com.vivekvishwanath.restmvvmdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vivekvishwanath.restmvvmdemo.R
import kotlinx.android.synthetic.main.activity_recipe_list.*

class RecipeListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        test.setOnClickListener {
            showProgressBar(progressBar.visibility != View.VISIBLE)
        }
    }
}
