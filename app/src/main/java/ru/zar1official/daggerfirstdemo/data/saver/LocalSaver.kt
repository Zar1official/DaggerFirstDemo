package ru.zar1official.daggerfirstdemo.data.saver

interface LocalSaver {
    fun saveLocally(data: String)
    fun read(): String
}