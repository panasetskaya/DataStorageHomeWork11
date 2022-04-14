package com.example.datastoragehomework11.domain

interface MainRepository {

    fun addEmployee(employee: Employee)

    fun addPosition(position: Position)

    fun getAllPositions()

    fun getEmployeesByPosition(position: Position)
}
