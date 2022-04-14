package com.example.datastoragehomework11.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Position(
    @PrimaryKey
    val title: String)
