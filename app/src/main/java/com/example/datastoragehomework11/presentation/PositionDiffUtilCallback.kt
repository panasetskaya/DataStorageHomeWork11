package com.example.datastoragehomework11.presentation


import androidx.recyclerview.widget.DiffUtil
import com.example.datastoragehomework11.domain.Position

class PositionDiffUtilCallback: DiffUtil.ItemCallback<Position>() {
    override fun areItemsTheSame(oldItem: Position, newItem: Position): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Position, newItem: Position): Boolean {
        return oldItem.title == newItem.title
    }
}