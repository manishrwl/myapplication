package com.example.myapplication.recyclerview

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CharacterVH1(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCharacterName = view.findViewById<TextView>(R.id.tvCharacterName)
    private val tvSrNo = view.findViewById<TextView>(R.id.tvSrNo)

    /*
    * Setting the values from the data
    * */
    fun bind(characterName: String) {
        tvSrNo.text = (adapterPosition + 1).toString()
        tvCharacterName.text = characterName
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, characterName, Toast.LENGTH_SHORT).show()
        }
    }
}


class CharacterVH2(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCharacterName = view.findViewById<TextView>(R.id.tvCharacterName)
    private val tvSrNo = view.findViewById<TextView>(R.id.tvSrNo)

    /*
        * Setting the values from the data
        * */
    fun bind(characterName: String) {
        tvSrNo.text = (adapterPosition + 1).toString()
        tvCharacterName.text = characterName
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, characterName, Toast.LENGTH_SHORT).show()
        }
    }
}