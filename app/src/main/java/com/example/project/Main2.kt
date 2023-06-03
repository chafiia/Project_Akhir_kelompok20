package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main2 : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homee -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, Home())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.acount -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, Accoun())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.notif -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, Notif())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, Home())
            .commit()

    }
}