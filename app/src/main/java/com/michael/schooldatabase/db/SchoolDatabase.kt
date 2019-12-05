package com.michael.schooldatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.michael.schooldatabase.model.*

@Database(entities = [Student::class, Course::class, Enrollment::class], version = 1, exportSchema = false)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun schoolDao(): SchoolDAO

    companion object {
        @Volatile private var instance: SchoolDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            SchoolDatabase::class.java, "School.db")
            .build()
    }
}