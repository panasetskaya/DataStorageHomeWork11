package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData

class GetAllPositionsUseCase(private val repo: MainRepository) {

    fun invoke(): LiveData<List<Position>> {
        return repo.getAllPositions()
    }
}