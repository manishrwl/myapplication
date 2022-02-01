package com.example.myapplication.camera

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment.DIRECTORY_PICTURES
import android.os.SystemClock
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.myapplication.R
import java.io.File

class CameraActivity() : AppCompatActivity() {

    private var photoURI: Uri? = null


    companion object {
        const val REQ_CODE = 34567
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)


        findViewById<View>(R.id.takePhoto).setOnClickListener {
            val file = File(getExternalFilesDir(DIRECTORY_PICTURES), "myimage${SystemClock.elapsedRealtime()}.jpg")
            if (file.exists()) file.delete()
            file.createNewFile()
            photoURI = FileProvider.getUriForFile(
                this,
                "${packageName}.fileprovider",
                file
            )

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            startActivityForResult(intent, REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {
            val imageView = findViewById<ImageView>(R.id.imageView2)
            //imageView.setImageBitmap(intent?.extras?.getParcelable("data"))\
            if (photoURI != null) {
                imageView.setImageURI(photoURI)
                Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
                    mediaScanIntent.data = photoURI
                    sendBroadcast(mediaScanIntent)
                }
            }

        }
    }
}