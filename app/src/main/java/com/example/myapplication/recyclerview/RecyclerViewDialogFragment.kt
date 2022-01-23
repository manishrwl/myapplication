package com.example.myapplication.recyclerview

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.R

const val TAG = "RecyclerViewDialogFragment"

class RecyclerViewDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recyclerview_demo, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog?.setTitle("Marvel Character Name")
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvCharacter = view.findViewById<RecyclerView>(R.id.rvCharacters)

        // How to arrange Item in Recycler View
        rvCharacter.layoutManager = LinearLayoutManager(requireContext())
        // rvCharacter.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        //rvCharacter.layoutManager = GridLayoutManager(requireContext(), 2)
        // rvCharacter.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        // test data
        val testData = arrayListOf<String>()
        testData.add("Captain America")
        testData.add("Ant Man")
        testData.add("Iron Man")
        testData.add("Thor")
        testData.add("Spider-man")
        testData.add("Hawk Eye")
        testData.add("Hulk")
        testData.add("Black Widow")
        testData.add("Blade")
        testData.add("Thanos")
        testData.add("Gamora")
        testData.add("Black Panther")
        testData.add("Star Lord")
        testData.sort()

        // Set adapter with data
        rvCharacter.adapter = MarvelAdapter(testData)
    }
}