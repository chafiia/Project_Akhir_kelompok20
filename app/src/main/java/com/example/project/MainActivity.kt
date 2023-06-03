package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}