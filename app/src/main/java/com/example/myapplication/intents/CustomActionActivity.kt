package com.example.myapplication.intents

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.data
        Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
    }
}