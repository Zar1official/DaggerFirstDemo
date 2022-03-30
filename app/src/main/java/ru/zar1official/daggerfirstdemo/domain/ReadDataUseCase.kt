package ru.zar1official.daggerfirstdemo.domain

class ReadDataUseCase(private val repository: Repository) {
    suspend fun invoke(key: String) =
        repository.readUserName(key)
}