package ru.zar1official.daggerfirstdemo.domain

class SaveDataUseCase(private val repository: Repository) {
    suspend fun invoke(key: String, value: String) {
        repository.writeUserName(key, value)
    }
}