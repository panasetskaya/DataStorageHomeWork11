package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Flowable

interface MainRepository {

    fun addEmployee(employee: Employee)

    fun addPosition(position: Position)

    fun getAllPositions(): Flowable<List<Position>>

    fun getEmployeesByPosition(position: String): Flowable<List<Employee>>
}
