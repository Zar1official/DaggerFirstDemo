package ru.zar1official.daggerfirstdemo.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.RepositoryImpl
import ru.zar1official.daggerfirstdemo.domain.Repository
import javax.inject.Singleton

@Module
class DataModule {
    val Context.dataStore by preferencesDataStore(name = "store")

    @Provides
    fun provideDataStore(context: Context): DataStore<Preferences> = context.dataStore

    @Provides
    fun provideRepository(dataStore: DataStore<Preferences>): Repository =
        RepositoryImpl(dataStore = dataStore)
}