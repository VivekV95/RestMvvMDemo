package com.vivekvishwanath.restmvvmdemo.activity

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.vivekvishwanath.restmvvmdemo.R
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity: AppCompatActivity() {

    lateinit var progressBar: ProgressBar

    override fun setContentView(layoutResID: Int) {
        val constraintLayout = layoutInflater.inflate(R.layout.activity_base, null)
        val frameLayout = constraintLayout.findViewById<FrameLayout>(R.id.activity_content)
        progressBar = constraintLayout.findViewById(R.id.progress_bar)

        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)
    }

    fun showProgressBar(visibility: Boolean) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
    }
}
