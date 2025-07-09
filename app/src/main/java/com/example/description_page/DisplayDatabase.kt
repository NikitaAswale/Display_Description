package com.example.description_page

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Description::class], version = 1)
abstract class DescriptionDatabase : RoomDatabase() {
    abstract fun descriptionDao(): DescriptionDao

    companion object {
        @Volatile private var INSTANCE: DescriptionDatabase? = null

        fun getDatabase(context: Context): DescriptionDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DescriptionDatabase::class.java,
                    "notes1_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}