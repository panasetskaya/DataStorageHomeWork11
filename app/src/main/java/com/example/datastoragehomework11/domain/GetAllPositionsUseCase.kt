package com.example.datastoragehomework11.domain

class GetAllPositionsUseCase(private val repo: MainRepository) {

    fun invoke() {
        repo.getAllPositions()
    }
}