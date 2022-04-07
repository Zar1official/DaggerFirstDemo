package ru.zar1official.daggerfirstdemo.data.saver

interface Saver {
    fun save(data: String)
    fun read(): String
}