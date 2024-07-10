package com.example.islamiappproject.islamiapp.a.islamiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.islamiappproject.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(mainLooper).postDelayed({
              val intent=Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        },2500)
    }
}