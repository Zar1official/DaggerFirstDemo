package ru.zar1official.daggerfirstdemo.di.components

import dagger.Component
import ru.zar1official.daggerfirstdemo.di.app.AppModule
import ru.zar1official.daggerfirstdemo.di.app.ThirdScreenModule
import ru.zar1official.daggerfirstdemo.di.data.DataModule
import ru.zar1official.daggerfirstdemo.di.domain.DomainModule
import ru.zar1official.daggerfirstdemo.presentation.screens.FirstFragment
import ru.zar1official.daggerfirstdemo.presentation.screens.MainActivity
import ru.zar1official.daggerfirstdemo.presentation.screens.SecondFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(firstFragment: FirstFragment)
    fun inject(secondFragment: SecondFragment)
    fun plusThirdScreenComponent(thirdScreenModule: ThirdScreenModule): ThirdScreenComponent
}
