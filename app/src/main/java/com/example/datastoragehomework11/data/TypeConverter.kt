package com.example.datastoragehomework11.data

import androidx.room.TypeConverter
import com.example.datastoragehomework11.domain.Position

class TypeConverter {

    @TypeConverter
    fun fromPosition(position: Position): String {
        return position.title
    }

    @TypeConverter
    fun toPosition(position: String): Position {
        return Position(position)
    }
}