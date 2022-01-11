package com.example.myapplication.data

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SharedPreferencesActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        // Create a shaerd pref & keep the ref
        sharedPref = getSharedPreferences("myappdata", Context.MODE_PRIVATE)

        val editText = findViewById<EditText>(R.id.editTextTextPersonName)

        // Save the data in shared preference
        findViewById<View>(R.id.buttonSave).setOnClickListener {
            val name = editText.text.toString()
            val editor = sharedPref.edit()
            editor.putString("name", name)
            val isDone = editor.commit() // Syncronous execution
            // editor.apply() // Asyncronous execution
            if (isDone) {
                Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
            }

            // or you can call apply
        }

        // Get the data from Shared preference
        findViewById<View>(R.id.buttonGet).setOnClickListener {
            val data = sharedPref.getString("name", "data not available")
            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }


        // Example of how to save dota in shared pref

        // Single
        sharedPref.edit().putBoolean("isChecked", true).apply()

        // multiple
        sharedPref.edit()
            .putInt("age", 31)
            .putFloat("Balance", 5237237.30f)
            .putLong("accountno", 5353453535334545)
            .apply()

        val set = mutableSetOf<String>()
        set.add("Modinagar")
        set.add("Delhi")
        set.add("Noida")
        set.add("Lucknow")
        set.add("Meerut")

        sharedPref.edit().putStringSet("cityOfhouses", set).commit()

    }
}
