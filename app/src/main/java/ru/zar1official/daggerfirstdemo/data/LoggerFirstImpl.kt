package ru.zar1official.daggerfirstdemo.data

import android.util.Log

class LoggerFirstImpl: Logger {
    override fun log() {
        Log.d("first", "works")
    }
}