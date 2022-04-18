package com.example.datastoragehomework11.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datastoragehomework11.R

class PositionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val positionTitle = view.findViewById<TextView>(R.id.item_position_title)
}