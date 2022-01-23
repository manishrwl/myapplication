package com.example.myapplication.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MarvelAdapter(val items: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> CharacterVH1(
                LayoutInflater.from(parent.context).inflate(R.layout.item_character1, parent, false)
            )
            else -> CharacterVH2(
                LayoutInflater.from(parent.context).inflate(R.layout.item_character2, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val characterName = items.get(position)
        when (holder) {
            is CharacterVH1 -> {
                holder.bind(characterName)
            }
            is CharacterVH2 -> {
                holder.bind(characterName)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position.rem(2)== 0) 1 else 0
    }

    override fun getItemCount(): Int {
        return items.size
    }
}