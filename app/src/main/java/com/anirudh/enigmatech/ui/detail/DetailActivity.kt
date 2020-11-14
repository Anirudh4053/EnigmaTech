package com.anirudh.enigmatech.ui.detail

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.anirudh.enigmatech.R
import com.anirudh.enigmatech.data.model.User
import com.anirudh.enigmatech.data.showToast
import com.anirudh.enigmatech.data.validateError
import kotlinx.android.synthetic.main.activity_detail.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class DetailActivity : AppCompatActivity(),DetailListener, KodeinAware {
    private var refreshFlag = false
    override val kodein by kodein()
    private val factory by instance<DetailViewModelFactory>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(this,factory).get(DetailViewModel::class.java)
        viewModel.detailListener = this

        backBtn.setOnClickListener {
            onBackPressed()
        }
        submitBtn.setOnClickListener {
            val fname = fnamEditText.text.toString().trim()
            val lname = lnameEditText.text.toString().trim()
            val age = ageEditText.text.toString().trim()
            if(!validateError(this,fname,"first name") || !validateError(this,fname,"surname")
                || !validateError(this,fname,"age"))
                return@setOnClickListener
            else {
                val userData = User(fname,lname,age.toInt())
                viewModel.insertRecord(userData)
            }
        }
    }

    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("refresh", refreshFlag)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    override fun onStarted() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        showToast("Saved Successfully")
        progressBar.visibility = View.GONE
        refreshFlag = true
        onBackPressed()
    }

    override fun onFailure(message: String) {
        showToast(message)
        progressBar.visibility = View.GONE
        refreshFlag = false
    }
}