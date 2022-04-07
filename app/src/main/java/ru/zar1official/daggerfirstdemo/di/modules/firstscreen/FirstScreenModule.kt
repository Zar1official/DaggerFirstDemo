package ru.zar1official.daggerfirstdemo.di.modules.firstscreen

import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaverImpl
import ru.zar1official.daggerfirstdemo.di.modules.SaverModule
import ru.zar1official.daggerfirstdemo.di.scopes.FirstScreenScope
import ru.zar1official.daggerfirstdemo.di.scopes.ThirdScreenScope

@Module
class FirstScreenModule {
    @FirstScreenScope
    @Provides
    fun provideSaver(): LocalSaver = LocalSaverImpl()
}