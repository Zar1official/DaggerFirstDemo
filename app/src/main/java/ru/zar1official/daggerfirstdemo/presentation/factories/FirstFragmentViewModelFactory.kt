package ru.zar1official.daggerfirstdemo.presentation.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zar1official.daggerfirstdemo.domain.SaveDataUseCase
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.FirstFragmentViewModel

class FirstFragmentViewModelFactory(private val saveDataUseCase: SaveDataUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = FirstFragmentViewModel(saveDataUseCase = saveDataUseCase) as T
}