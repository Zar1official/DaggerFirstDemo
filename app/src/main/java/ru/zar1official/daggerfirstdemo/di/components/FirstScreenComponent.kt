package ru.zar1official.daggerfirstdemo.di.components

import dagger.Subcomponent
import ru.zar1official.daggerfirstdemo.di.modules.firstscreen.FirstScreenModule
import ru.zar1official.daggerfirstdemo.di.scopes.FirstScreenScope
import ru.zar1official.daggerfirstdemo.presentation.screens.FirstFragment

@FirstScreenScope
@Subcomponent(modules = [FirstScreenModule::class])
interface FirstScreenComponent {
    fun inject(firstFragment: FirstFragment)
}