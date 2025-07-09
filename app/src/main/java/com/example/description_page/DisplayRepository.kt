package com.example.description_page

import kotlinx.coroutines.flow.Flow

class DescriptionRepository(private val descriptionDao: DescriptionDao) {

    suspend fun getAllDescription() : Flow<List<Description>> {
        return descriptionDao.getAllDescription()
    }

    suspend fun insert(description: Description) {
        descriptionDao.insert(description)
    }

    suspend fun deleteById(id: Int) {
        descriptionDao.deleteById(id)
    }
}