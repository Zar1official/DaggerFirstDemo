package ru.zar1official.daggerfirstdemo.di.modules.app

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object StorageModule {
    private val Context.dataStore by preferencesDataStore(name = "store")

    @Singleton
    @Provides
    fun provideDataStore(context: Context): DataStore<Preferences> = context.dataStore
}