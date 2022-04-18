package com.example.datastoragehomework11.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.datastoragehomework11.domain.Employee

class EmployeeItemDiffCallback: DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.age == newItem.age &&
                oldItem.experience == newItem.experience &&
                oldItem.position == newItem.position
    }
}