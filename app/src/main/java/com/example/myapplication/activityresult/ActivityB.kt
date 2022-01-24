package com.example.myapplication.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity B"


        val ll = LinearLayout(this)
        val button = Button(this)
        button.text = "Send Result"

        ll.addView(button, -1, -2)

        setContentView(ll)

        // get data from bundle
        val bundle = intent.extras
        val data = bundle?.getString(ActivityA.DATA)

        Toast.makeText(this, data, Toast.LENGTH_LONG).show()

        button.setOnClickListener {
            // setResult(Activity.RESULT_OK)
            val resultIntent = Intent()
            resultIntent.putExtra(ActivityA.DATA, "Result from Activity B")

            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        setResult(RESULT_CANCELED)
    }
}