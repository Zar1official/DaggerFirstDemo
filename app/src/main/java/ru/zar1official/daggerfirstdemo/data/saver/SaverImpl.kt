package ru.zar1official.daggerfirstdemo.data.saver

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SaverImpl @Inject constructor(): Saver {
    private var value = ""
    override fun save(data: String) {
        value = data
    }

    override fun read(): String = value

}