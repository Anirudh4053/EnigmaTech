package com.anirudh.enigmatech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anirudh.enigmatech.data.hideStatusBar

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.hideStatusBar()
        val timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(5000)

                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    //Crashlytics.getInstance().crash()
                    val i = Intent(this@SplashActivity,HomeActivity::class.java)
                    startActivity(i)
                    finish()


                }
            }
        }
        timer.start()
    }
}