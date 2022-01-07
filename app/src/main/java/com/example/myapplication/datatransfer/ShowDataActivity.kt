package com.example.myapplication.datatransfer

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ShowDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_data)

        val tvShowData = findViewById<TextView>(R.id.textViewShowData)
        val intent = intent

        // first Check data is available
        if (intent.hasExtra("myData")) {
            // get the data from the intent
            val data = intent.getStringExtra("myData")

            // set the data on textview to showon screen
            tvShowData.setText(data)
        }
    }


}