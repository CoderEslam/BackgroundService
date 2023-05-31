package com.doubleclick.backgroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "KotlinApp"
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            startService(Intent(applicationContext, MyService::class.java))
        }

    }
}