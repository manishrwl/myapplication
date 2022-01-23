package com.example.myapplication.imageslider

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import kotlin.math.abs
import kotlin.math.log

class ImageSliderWithGesturesDialogFragment : DialogFragment(), GestureDetector.OnGestureListener {

    private val imageListArray = Array<Int>(5) { 0 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageListArray[0] = R.drawable.image_one
        imageListArray[1] = R.drawable.image_two
        imageListArray[2] = R.drawable.image_three
        imageListArray[3] = R.drawable.image_four
        imageListArray[4] = R.drawable.image_five
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_image_slider_with_gesture,
            container,
            false
        )
    }

    var imageView: ImageView? = null
    var currentIndex = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.imageView)
        imageView?.setImageResource(imageListArray[currentIndex])
        val gestureDetectorCompat = GestureDetectorCompat(context, this)
        imageView?.setOnTouchListener { v, event ->
            gestureDetectorCompat.onTouchEvent(event)
            return@setOnTouchListener true
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(-1, -1)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
    }

    override fun onDown(e: MotionEvent?): Boolean {
        // Do nothing
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        // Do nothing
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        // Do nothing
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        // Do nothing
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        // Do nothing
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        val change = abs(velocityX) > (velocityY)
        if (change) {
            if (e1?.x ?: 0F > e2?.x ?: 0F) {
                if (currentIndex == imageListArray.size.minus(1))
                    currentIndex = 0
                else
                    currentIndex += 1
            } else if (e1?.x ?: 0F < e2?.x ?: 0F) {
                if (currentIndex == 0)
                    currentIndex = imageListArray.size.minus(1)
                else
                    currentIndex -= 1
            }
            imageView?.setImageResource(imageListArray[currentIndex])
        }

        return false
    }
}