package com.example.AtividadeM2Halloween

import android.app.Application
import androidx.room.Room
import com.example.AtividadeM2Halloween.database.AppDatabase

class MeuApp : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()
    }
}
