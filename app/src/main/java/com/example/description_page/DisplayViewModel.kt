package com.example.description_page

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DescriptionViewModel(application : Application) : AndroidViewModel(application) {

    private val database =(application as DescriptionApplication).database

    //Repository instance
    val repository by lazy {
        DescriptionRepository(database.descriptionDao())
    }
    private val _notes: MutableStateFlow<List<Description>> = MutableStateFlow(emptyList())
    val description : StateFlow<List<Description>> = _notes

    init {
        getAllDescription()
    }

    private fun getAllDescription() {
        viewModelScope.launch {
            repository.getAllDescription().collect {
                _notes.value = it
            }
        }
    }

    fun addDescription(title: String) {
        viewModelScope.launch {
            if (title.isNotEmpty()) {
                repository.insert(
                    Description(
                        title = title
                    )
                )
            }
        }
    }


    fun deleteDescription(id: Int) {
        viewModelScope.launch {
            repository.deleteById(id)
        }
    }
}