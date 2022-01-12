package com.example.myapplication.data

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.EnvironmentCompat
import com.example.myapplication.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_files)


        val editText = findViewById<EditText>(R.id.etInformation)
        val tvFileInfoData = findViewById<TextView>(R.id.tvFileInfo)


        // How to write a file in Application folder
        findViewById<View>(R.id.buttonSaveToFile).setOnClickListener {
            val info = editText.text.toString()
            try {
                // File Open
                // Context.MODE_APPEND : Append the new data in old data
                // Context.MODE_PRIVATE : Override the existing data
                val file = this.openFileOutput("info", Context.MODE_APPEND)
                // Write info
                file.write(info.toByteArray())
                // file close
                file.close()

                Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "File Saved Error", Toast.LENGTH_LONG).show()
            }
        }

        // How to read file from private application folder
        findViewById<View>(R.id.buttonShowFileInfo).setOnClickListener {
            try {
                // Open
                val file = this.openFileInput("info")

                // Read Data
                val buffer = ByteArray(1024)
                var string = ""
                while (file.read(buffer) != -1) {
                    string = string + String(buffer)
                }

                // Close the File
                file.close()

                tvFileInfoData.text = string

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        // How to create custom dir & file & write to it
        findViewById<View>(R.id.buttonSaveMyDirFile).setOnClickListener {
            try {
                val myFolder = getDir("myFolder", Context.MODE_PRIVATE)
                val myCustomFile = File(myFolder, "mycustom.txt")
                // if file is not available then create new file
                if (!myCustomFile.exists()) myCustomFile.createNewFile()

                // open stream for wrinting
                val fileOutputStream = FileOutputStream(myCustomFile)
                fileOutputStream.write("This is my data will be in file".toByteArray())
                fileOutputStream.flush()
                fileOutputStream.close()
                Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


        // How to read custom dir & file
        findViewById<View>(R.id.buttonReadMyDirFile).setOnClickListener {
            try {
                val myFolder = getDir("myFolder", Context.MODE_PRIVATE)
                val myCustomFile = File(myFolder, "mycustom.txt")
                // open stream for reading
                val fileInputStream = FileInputStream(myCustomFile)

                /* // Read Data
                 val buffer = ByteArray(1024)
                 var string = ""
                 while (fileInputStream.read(buffer) != -1) {
                     string = string + String(buffer)
                 }*/

                // Kotlin helper function
                val text = fileInputStream.bufferedReader().readText()

                // Close the File
                fileInputStream.close()
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
