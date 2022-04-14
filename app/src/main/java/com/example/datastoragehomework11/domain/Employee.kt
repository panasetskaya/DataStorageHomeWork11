package com.example.datastoragehomework11.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey
    var name: String,
    var age: Int,
    var experience: Int,
    var position: Position)
