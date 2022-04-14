package com.example.datastoragehomework11.domain

class AddPositionUseCase(private val repo: MainRepository) {

    fun invoke(position: Position) {
        repo.addPosition(position)
    }
}