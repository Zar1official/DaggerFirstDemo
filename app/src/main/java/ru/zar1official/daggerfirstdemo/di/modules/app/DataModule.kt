package ru.zar1official.daggerfirstdemo.di.modules.app

import dagger.Binds
import dagger.Module
import ru.zar1official.daggerfirstdemo.data.repositories.RepositoryImpl
import ru.zar1official.daggerfirstdemo.data.saver.Saver
import ru.zar1official.daggerfirstdemo.data.saver.SaverImpl
import ru.zar1official.daggerfirstdemo.domain.Repository

@Module(includes = [StorageModule::class, LoggerModule::class])
abstract class DataModule {
    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindSaver(saverImpl: SaverImpl): Saver
}