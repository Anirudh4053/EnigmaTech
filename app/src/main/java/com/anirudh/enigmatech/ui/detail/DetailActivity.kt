package com.anirudh.enigmatech.ui.detail

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anirudh.enigmatech.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("refresh", true)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}