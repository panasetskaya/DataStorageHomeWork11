package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData

class GetEmployeesByPosition(private val repo: MainRepository) {
    fun invoke(position: String): LiveData<List<Employee>> {
        return repo.getEmployeesByPosition(position)
    }
}