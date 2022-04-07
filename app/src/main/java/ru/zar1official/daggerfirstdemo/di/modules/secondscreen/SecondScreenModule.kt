package ru.zar1official.daggerfirstdemo.di.modules.secondscreen

import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaverImpl
import ru.zar1official.daggerfirstdemo.di.scopes.SecondScreenScope

@Module
class SecondScreenModule {
    @SecondScreenScope
    @Provides
    fun provideSaver(): LocalSaver = LocalSaverImpl()
}