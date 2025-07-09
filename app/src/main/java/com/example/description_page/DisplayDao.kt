package com.example.description_page

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DescriptionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(description: Description)

    @Query("SELECT * FROM description ORDER BY id ASC")
    fun getAllDescription(): Flow<List<Description>>

    @Query("DELETE FROM description WHERE id = :id")
    suspend fun deleteById(id: Int)
}