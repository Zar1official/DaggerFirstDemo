package ru.zar1official.daggerfirstdemo.di.data

import dagger.Binds
import dagger.Module
import ru.zar1official.daggerfirstdemo.data.repositories.RepositoryImpl
import ru.zar1official.daggerfirstdemo.domain.Repository

@Module(includes = [StorageModule::class, LoggerModule::class])
abstract class DataModule {
    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}