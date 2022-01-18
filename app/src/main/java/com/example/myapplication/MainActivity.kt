package com.example.myapplication


import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.activityLifecycle.LifeCycleActivity
import com.example.myapplication.data.FileActivity
import com.example.myapplication.data.SharedPreferencesActivity
import com.example.myapplication.datatransfer.TransferDataActivity
import com.example.myapplication.intents.IntentActivity
import com.example.myapplication.login.LoginActivity

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


        findViewById<View>(R.id.tvLoginUi).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        findViewById<View>(R.id.tvSP).setOnClickListener {
            startActivity(Intent(this, SharedPreferencesActivity::class.java))
        }

        findViewById<View>(R.id.tvFileData).setOnClickListener {
            startActivity(Intent(this, FileActivity::class.java))
        }

        findViewById<View>(R.id.buttonIntent).setOnClickListener {
            startActivity(Intent(this, IntentActivity::class.java))
        }
    }
}