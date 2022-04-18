package com.example.datastoragehomework11.domain

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Flowable

class GetAllPositionsUseCase(private val repo: MainRepository) {

    fun invoke(): Flowable<List<Position>> {
        return repo.getAllPositions()
    }
}