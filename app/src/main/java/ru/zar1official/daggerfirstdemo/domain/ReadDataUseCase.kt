package ru.zar1official.daggerfirstdemo.domain

import javax.inject.Inject

class ReadDataUseCase @Inject constructor(private val repository: Repository) {
    suspend fun invoke(key: String) =
        repository.readUserName(key)
}