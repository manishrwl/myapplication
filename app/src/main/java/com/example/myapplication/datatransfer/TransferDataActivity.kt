package com.example.myapplication.datatransfer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class TransferDataActivity : AppCompatActivity() {

    private lateinit var buttonSendData: Button
    private lateinit var etData: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tansfer_data)
        setUpUi()
        setClickListener()
    }


    /*
    * Read data from Edit text & send it Next Activity
    * Validation also
    * */
    private fun setClickListener() {
        buttonSendData.setOnClickListener {
            val data = etData.text.toString()
            if (data.isNotEmpty()) {
                // Hide error
                etData.error = null

                //Transfer data to next Screen
                val intent = Intent(this, ShowDataActivity::class.java)
                //add data in intent
                intent.putExtra("myData", data)
                startActivity(intent)

                // Clear the editText
                etData.setText("")

            } else {
                // Show error on Empty Data
                etData.error = "Please enter your data"
            }
        }
    }

    private fun setUpUi() {
        etData = findViewById<EditText>(R.id.etData)
        buttonSendData = findViewById<Button>(R.id.buttonSendData)
    }

}