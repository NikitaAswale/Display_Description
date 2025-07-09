package com.example.description_page

import android.app.Application

class DescriptionApplication : Application() {
    // Lazy initialization of database
    val database by lazy {
        DescriptionDatabase.getDatabase(this)
    }
}