package com.example.datastoragehomework11.domain

class GetEmployeesByPosition(private val repo: MainRepository) {
    fun invoke(position: Position) {
        repo.getEmployeesByPosition(position)
    }
}