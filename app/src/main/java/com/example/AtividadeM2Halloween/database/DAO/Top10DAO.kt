package com.example.AtividadeM2Halloween.database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.AtividadeM2Halloween.database.model.Top10

@Dao
interface Top10Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTop10(movie: Top10)

    @Query("SELECT * FROM top10_table")
    suspend fun getAllTop10(): List<Top10>

}
