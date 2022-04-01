package ru.zar1official.daggerfirstdemo.domain

import javax.inject.Inject

class SaveDataUseCase @Inject constructor(private val repository: Repository) {
    suspend fun invoke(key: String, value: String) {
        repository.writeUserName(key, value)
    }
}