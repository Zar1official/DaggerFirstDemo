package ru.zar1official.daggerfirstdemo.di.components

import dagger.Subcomponent
import ru.zar1official.daggerfirstdemo.di.modules.thirdscreen.ThirdScreenModule
import ru.zar1official.daggerfirstdemo.di.scopes.ThirdScreenScope
import ru.zar1official.daggerfirstdemo.presentation.screens.ThirdFragment

@ThirdScreenScope
@Subcomponent(modules = [ThirdScreenModule::class])
interface ThirdScreenComponent {
    fun inject(thirdFragment: ThirdFragment)
}