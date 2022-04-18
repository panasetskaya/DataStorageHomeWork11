package com.example.datastoragehomework11.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.datastoragehomework11.domain.Employee
import com.example.datastoragehomework11.domain.Position
import io.reactivex.rxjava3.core.Flowable

@Dao
interface EmploymentDao {

    @Query("SELECT * FROM position")
    fun getAllPositions(): Flowable<List<Position>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEmployee(employee: Employee)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPosition(position: Position)

    @Query("SELECT * FROM employee WHERE position==:position")
    fun getEmployeesByPosition(position: String): Flowable<List<Employee>>

}
