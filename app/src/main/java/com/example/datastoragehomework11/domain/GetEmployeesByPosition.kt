package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData

class GetEmployeesByPosition(private val repo: MainRepository) {
    fun invoke(position: Position): LiveData<List<Employee>> {
        return repo.getEmployeesByPosition(position.title)
    }
}