package com.example.AtividadeM2Halloween.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top10_table")
data class Top10(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val imageResourceId: Int
)
