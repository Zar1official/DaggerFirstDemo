package ru.zar1official.daggerfirstdemo.di

import dagger.Component
import ru.zar1official.daggerfirstdemo.presentation.screens.FirstFragment
import ru.zar1official.daggerfirstdemo.presentation.screens.MainActivity

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: FirstFragment)
}