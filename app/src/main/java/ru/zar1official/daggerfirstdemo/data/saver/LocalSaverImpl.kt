package ru.zar1official.daggerfirstdemo.data.saver

import javax.inject.Inject
import javax.inject.Singleton

class LocalSaverImpl: LocalSaver {
    var value: String = ""
    override fun saveLocally(data: String) {
        value = data
    }

    override fun read(): String = value
}