package com.example.myapplication.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        /* EXAMPLE OF EXPLICIT INTENT */

        // How to open a phone dialer
        // ACTION
        // DATA
        findViewById<View>(R.id.buttonOpenDialer).setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:9643880467")))
        }

        // How to call directly
        findViewById<View>(R.id.buttonCall).setOnClickListener {
            // Need to check permission is allowed or not
            try {
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:9643880467")))
            } catch (e: SecurityException) {
                Toast.makeText(
                    this,
                    "Don't have permission. Please enable it from Settings",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


        /* EXAMPLE OF IMPLICIT INTENT */

        // How to open Websites/URl
        findViewById<View>(R.id.buttonOpenURL).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https:www.google.com")))
        }

        // How to open Phone Dial
        findViewById<View>(R.id.buttonActionView).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("tel:8851046291")))
        }

        // How to mail
        findViewById<View>(R.id.buttonOpenMail).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("mailto:tjdam007@gmail.com")))
        }

        // How to user intent filter with custom actions
        findViewById<View>(R.id.buttonCustomAction).setOnClickListener {
            val intent = Intent("thisismyaction", Uri.parse("myapp:testdata"))
            startActivity(intent)
        }
    }
}