package ru.zar1official.daggerfirstdemo.di.components

import dagger.Component
import ru.zar1official.daggerfirstdemo.di.modules.app.AppModule
import ru.zar1official.daggerfirstdemo.di.modules.app.DataModule
import ru.zar1official.daggerfirstdemo.di.modules.firstscreen.FirstScreenModule
import ru.zar1official.daggerfirstdemo.di.modules.secondscreen.SecondScreenModule
import ru.zar1official.daggerfirstdemo.di.modules.thirdscreen.ThirdScreenModule
import ru.zar1official.daggerfirstdemo.presentation.screens.FirstFragment
import ru.zar1official.daggerfirstdemo.presentation.screens.MainActivity
import ru.zar1official.daggerfirstdemo.presentation.screens.SecondFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(firstFragment: FirstFragment)
    fun inject(secondFragment: SecondFragment)
    fun plusFirstScreenComponent(firstScreenModule: FirstScreenModule): FirstScreenComponent
    fun plusSecondScreenComponent(secondScreenModule: SecondScreenModule): SecondScreenComponent
    fun plusThirdScreenComponent(thirdScreenModule: ThirdScreenModule): ThirdScreenComponent
}
