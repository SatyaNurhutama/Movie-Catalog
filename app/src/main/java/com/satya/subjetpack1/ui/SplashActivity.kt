package com.satya.subjetpack1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.satya.subjetpack1.R
import com.satya.subjetpack1.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            val moveIntent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(moveIntent)
            finish()
        }, 3000)
    }
}