package com.example.myapplication


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.activityLifecycle.LifeCycleActivity
import com.example.myapplication.datatransfer.TransferDataActivity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenWifi = findViewById<Button>(R.id.buttonOpenWifi)
        buttonOpenWifi.setOnClickListener {
            // this will start Second Activity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val textViewImage = findViewById<TextView>(R.id.textViewImage)
        textViewImage.setOnClickListener {
            // this will start image Activity
            startActivity(Intent(this, ImageActivity::class.java))
        }

        val tvThirdActivity = findViewById<TextView>(R.id.Thirdactivity)
        tvThirdActivity.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        val textViewFourthactivity = findViewById<TextView>(R.id.fourthActivity)
        textViewFourthactivity.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }

        val tvTransferData = findViewById<View>(R.id.tvTransferData)
        tvTransferData.setOnClickListener {
            val intent = Intent(this, TransferDataActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.tvLifeCycle)
            .setOnClickListener {
                startActivity(Intent(this, LifeCycleActivity::class.java))
            }
    }
}

/*
*
*   // Current Layout = R.layout.activity_main
        // Layout set
        setContentView(R.layout.activity_main)
        // R = Resource file
        val buttonOpenWifi = findViewById<Button>(R.id.buttonOpenWifi)

        // Single Click
        /*buttonOpenWifi.setOnClickListener {
            // Start Second Activity
            startActivity(Intent(this, SecondActivity::class.java))
        }*/

        buttonOpenWifi.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity,"Single Click Listener",Toast.LENGTH_LONG).show()
            }
        })


        // Long Click
        buttonOpenWifi.setOnLongClickListener {
            Toast.makeText(this, "Long Pressed", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
* */


// Task
// Change App Name in Application Launcher

