package com.example.myapplication.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


/*
* UI using Code
* Activity Result
*
* */
class ActivityA : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 132
        const val DATA = "data"
    }

    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity A"
        // Linear Layout
        linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL

        // Button
        val button = Button(this)
        // Set text of Button
        button.text = "Start activity for result"

        // Add button in linear layout
        linearLayout.addView(button)

        setContentView(linearLayout)


        //TODO: MAIN CODE

        // Start Activity for Result
        button.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)

            val bundle = Bundle()
            bundle.putString(DATA, "Manoj Singh")

            intent.putExtras(bundle)

            startActivityForResult(intent, ActivityA.REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Result Recieved", Toast.LENGTH_LONG).show()

            val result = data?.getStringExtra(DATA)

            val textView = TextView(this)
            textView.text = result

            linearLayout.addView(textView)
        }
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "USER Cancled", Toast.LENGTH_LONG).show()
        }
    }

}