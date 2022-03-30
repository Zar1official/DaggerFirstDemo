package ru.zar1official.daggerfirstdemo.domain

interface Repository {
    suspend fun readUserName(key: String): String?
    suspend fun writeUserName(key: String, value: String)
}