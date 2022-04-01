package ru.zar1official.daggerfirstdemo.di.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.repositories.RepositoryImpl
import ru.zar1official.daggerfirstdemo.domain.Repository
import javax.inject.Singleton

@Module(includes = [StorageModule::class, LoggerModule::class])
object DataModule {
    @Singleton
    @Provides
    fun provideRepository(repositoryImpl: RepositoryImpl): Repository =
        repositoryImpl

    @Singleton
    @Provides
    fun provideRepositoryImpl(dataStore: DataStore<Preferences>) =
        RepositoryImpl(dataStore)
}