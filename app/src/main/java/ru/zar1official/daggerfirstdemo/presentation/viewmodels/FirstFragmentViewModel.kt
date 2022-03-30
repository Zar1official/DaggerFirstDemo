package ru.zar1official.daggerfirstdemo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.zar1official.daggerfirstdemo.domain.SaveDataUseCase

class FirstFragmentViewModel(private val saveDataUseCase: SaveDataUseCase) : ViewModel() {
    fun onSaveData(key: String, value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveDataUseCase.invoke(key, value)
        }
    }
}