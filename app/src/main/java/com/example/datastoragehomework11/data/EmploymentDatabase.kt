package com.example.datastoragehomework11.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.datastoragehomework11.domain.Employee
import com.example.datastoragehomework11.domain.Position

@Database(entities = [Employee::class, Position::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class EmploymentDatabase: RoomDatabase() {
    companion object {
        private val LOCK = Any()
        private const val DB_NAME = "employment.db"
        private var database: EmploymentDatabase? = null

        fun getInstance(context: Context): EmploymentDatabase {
            synchronized(LOCK) {
                if (database==null) {
                    val instance = Room.databaseBuilder(context, EmploymentDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                    database = instance
                    return instance
                }  else {
                return database as EmploymentDatabase
                }
            }
        }
    }
    abstract fun employmentDao(): EmploymentDao
}