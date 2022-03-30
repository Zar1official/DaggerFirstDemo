package ru.zar1official.daggerfirstdemo.presentation.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zar1official.daggerfirstdemo.domain.ReadDataUseCase
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.SecondFragmentViewModel

class SecondFragmentViewModelFactory(private val readDataUseCase: ReadDataUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        SecondFragmentViewModel(readDataUseCase = readDataUseCase) as T
}