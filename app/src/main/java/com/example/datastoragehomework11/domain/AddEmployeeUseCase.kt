package com.example.datastoragehomework11.domain

class AddEmployeeUseCase(private val repo: MainRepository) {
    fun invoke(employee: Employee) {
        repo.addEmployee(employee)
    }
}