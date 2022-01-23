package com.example.myapplication.imageslider

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R

class ImageSliderWithAnimationListDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_image_slider_with_animation_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView= view.findViewById<ImageView>(R.id.imageView)
        (imageView.background as AnimationDrawable).start()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(-1, -1)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
    }
}