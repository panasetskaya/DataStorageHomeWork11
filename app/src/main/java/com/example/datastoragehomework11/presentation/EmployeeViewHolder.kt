package com.example.datastoragehomework11.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datastoragehomework11.R

class EmployeeViewHolder(val view: View) : RecyclerView.ViewHolder(view)  {
    val employeeName = view.findViewById<TextView>(R.id.item_employee_name)
    val employeeAge = view.findViewById<TextView>(R.id.item_employee_age)
    val employeePosition = view.findViewById<TextView>(R.id.item_employee_position)
    val employeeExperience = view.findViewById<TextView>(R.id.item_employee_experience)
}