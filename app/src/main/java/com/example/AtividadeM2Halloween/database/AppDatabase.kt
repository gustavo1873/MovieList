package com.example.AtividadeM2Halloween.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.AtividadeM2Halloween.database.model.Top10
import com.example.AtividadeM2Halloween.database.DAO.Top10Dao

@Database(entities = [Top10::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun top10Dao(): Top10Dao
}