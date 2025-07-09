package com.example.description_page

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "description" )
data class Description(
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0,
    val title : String
)
