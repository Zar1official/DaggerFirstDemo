package ru.zar1official.daggerfirstdemo.di.modules.thirdscreen

import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaverImpl
import ru.zar1official.daggerfirstdemo.di.scopes.ThirdScreenScope

@Module
class ThirdScreenModule {
    @ThirdScreenScope
    @Provides
    fun provideSaver(): LocalSaver = LocalSaverImpl()
}