package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Flowable

class GetEmployeesByPosition(private val repo: MainRepository) {
    fun invoke(position: String): Flowable<List<Employee>> {
        return repo.getEmployeesByPosition(position)
    }
}