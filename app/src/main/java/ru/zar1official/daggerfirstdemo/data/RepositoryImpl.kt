package ru.zar1official.daggerfirstdemo.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import ru.zar1official.daggerfirstdemo.domain.Repository

class RepositoryImpl(private val dataStore: DataStore<Preferences>) : Repository {
    override suspend fun readUserName(key: String): String? {
        val dataStoreKey = stringPreferencesKey(name = key)
        val prefs = dataStore.data.first()
        return prefs[dataStoreKey]
    }

    override suspend fun writeUserName(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(name = key)
        dataStore.edit { user ->
            user[dataStoreKey] = value
        }
    }
}