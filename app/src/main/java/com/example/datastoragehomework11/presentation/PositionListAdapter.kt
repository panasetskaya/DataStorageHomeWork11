package com.example.datastoragehomework11.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.datastoragehomework11.R
import com.example.datastoragehomework11.domain.Position

class PositionListAdapter: ListAdapter<Position, PositionViewHolder>(PositionDiffUtilCallback()) {

    var onPositionItemClickListener: ((Position) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_position, parent, false)
        return PositionViewHolder(view)
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        val item = getItem(position)
        holder.positionTitle.text = item.title
        holder.view.setOnClickListener {
            onPositionItemClickListener?.invoke(item)
            true
        }
    }
}