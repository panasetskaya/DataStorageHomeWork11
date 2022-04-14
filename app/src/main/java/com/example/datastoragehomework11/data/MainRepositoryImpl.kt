package com.example.datastoragehomework11.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.datastoragehomework11.domain.Employee
import com.example.datastoragehomework11.domain.MainRepository
import com.example.datastoragehomework11.domain.Position

class MainRepositoryImpl(context: Context): MainRepository {

    private val db = EmploymentDatabase.getInstance(context)

    override fun addEmployee(employee: Employee) {
        db.employmentDao().addEmployee(employee)
    }

    override fun addPosition(position: Position) {
        db.employmentDao().addPosition(position)
    }

    override fun getAllPositions(): LiveData<List<Position>> {
        return db.employmentDao().getAllPositions()
    }

    override fun getEmployeesByPosition(position: String): LiveData<List<Employee>> {
        return db.employmentDao().getEmployeesByPosition(position)
    }
}