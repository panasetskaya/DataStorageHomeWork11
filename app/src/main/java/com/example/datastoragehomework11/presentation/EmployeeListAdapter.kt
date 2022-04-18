package com.example.datastoragehomework11.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import com.example.datastoragehomework11.R
import com.example.datastoragehomework11.domain.Employee

class EmployeeListAdapter: androidx.recyclerview.widget.ListAdapter<Employee, EmployeeViewHolder>(EmployeeItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_employee, parent, false
        )
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val item = getItem(position)
        holder.employeeName.text = item.name
        holder.employeeAge.text = item.age.toString()
        holder.employeePosition.text = item.position.title
        holder.employeeExperience.text = item.experience.toString()
    }
}