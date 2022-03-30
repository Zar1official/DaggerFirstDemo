package ru.zar1official.daggerfirstdemo.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.zar1official.daggerfirstdemo.domain.ReadDataUseCase

class SecondFragmentViewModel(private val readDataUseCase: ReadDataUseCase) : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    fun onReadData(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(readDataUseCase.invoke(key))
        }
    }
}