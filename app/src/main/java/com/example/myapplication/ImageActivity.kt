package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val imageLionPng = findViewById<ImageView>(R.id.imageLionPng)
        imageLionPng.setOnClickListener {
            Toast.makeText(this, "This is Lion PNG", Toast.LENGTH_LONG).show()
        }

        val imageLionWebp = findViewById<ImageView>(R.id.imageLionWebp)
        imageLionWebp.setOnClickListener {
            Toast.makeText(this, "This is Lion WEBP", Toast.LENGTH_LONG).show()
        }
    }

}