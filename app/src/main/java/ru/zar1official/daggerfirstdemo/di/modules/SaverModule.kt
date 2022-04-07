package ru.zar1official.daggerfirstdemo.di.modules

import dagger.Binds
import dagger.Module
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaverImpl

@Module
abstract class SaverModule {
    @Binds
    abstract fun bindSaver(saverImpl: LocalSaverImpl): LocalSaver
}