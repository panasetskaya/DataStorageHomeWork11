package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData

interface MainRepository {

    fun addEmployee(employee: Employee)

    fun addPosition(position: Position)

    fun getAllPositions(): LiveData<List<Position>>

    fun getEmployeesByPosition(position: String): LiveData<List<Employee>>
}
