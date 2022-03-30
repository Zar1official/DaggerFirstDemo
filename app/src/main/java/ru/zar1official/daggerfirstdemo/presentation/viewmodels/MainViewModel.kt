package ru.zar1official.daggerfirstdemo.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _state = MutableLiveData<Boolean>().apply { value = false }
    val state: LiveData<Boolean> = _state

    fun onChangeFragment() {
        _state.value = !state.value!!
    }
}