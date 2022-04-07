package ru.zar1official.daggerfirstdemo.di.components

import dagger.Subcomponent
import ru.zar1official.daggerfirstdemo.di.modules.secondscreen.SecondScreenModule
import ru.zar1official.daggerfirstdemo.di.scopes.SecondScreenScope
import ru.zar1official.daggerfirstdemo.presentation.screens.SecondFragment

@SecondScreenScope
@Subcomponent(modules = [SecondScreenModule::class])
interface SecondScreenComponent {
    fun inject(secondFragment: SecondFragment)
}