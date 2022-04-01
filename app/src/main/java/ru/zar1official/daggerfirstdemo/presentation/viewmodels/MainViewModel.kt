package ru.zar1official.daggerfirstdemo.presentation.viewmodels

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.zar1official.daggerfirstdemo.presentation.screens.FirstFragment
import ru.zar1official.daggerfirstdemo.presentation.screens.SecondFragment
import ru.zar1official.daggerfirstdemo.presentation.screens.ThirdFragment

class MainViewModel : ViewModel() {
    private val fragments = listOf(
        FirstFragment.newInstance(),
        SecondFragment.newInstance(),
        ThirdFragment.newInstance()
    )
    private var state = 0
    private val _currentFragment = MutableLiveData<Fragment>()
    val currentFragment: LiveData<Fragment> = _currentFragment

    fun onChangeFragment() {
        if (state == fragments.size - 1) {
            state = 0
        } else {
            state++
        }
        _currentFragment.value = fragments[state]
    }
}