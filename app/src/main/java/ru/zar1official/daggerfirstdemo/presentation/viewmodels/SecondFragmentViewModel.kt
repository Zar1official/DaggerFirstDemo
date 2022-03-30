package ru.zar1official.daggerfirstdemo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import ru.zar1official.daggerfirstdemo.domain.ReadDataUseCase

class SecondFragmentViewModel(private val readDataUseCase: ReadDataUseCase): ViewModel() {
}