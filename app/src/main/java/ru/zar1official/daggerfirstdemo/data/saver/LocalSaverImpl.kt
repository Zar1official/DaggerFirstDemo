package ru.zar1official.daggerfirstdemo.data.saver

class LocalSaverImpl : LocalSaver {
    var value: String = ""
    override fun save(data: String) {
        value = data
    }
}