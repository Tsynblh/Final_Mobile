package com.D121211081.Disney.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211081.Disney.MyApplication
import com.D121211081.Disney.data.models.Disney
import com.D121211081.Disney.data.repository.DisneyRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val disney: List<Disney>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val DisneyRepository: DisneyRepository): ViewModel() {

    // initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getDisney() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = DisneyRepository.getDisney()
            mainUiState = MainUiState.Success(result.data.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getDisney()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val newsRepository = application.container.DisneyRepository
                MainViewModel(newsRepository)
            }
        }
    }
}


