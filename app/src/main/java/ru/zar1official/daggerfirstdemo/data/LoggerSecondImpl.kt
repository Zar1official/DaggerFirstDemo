package ru.zar1official.daggerfirstdemo.data

import android.util.Log

class LoggerSecondImpl: Logger {
    override fun log() {
        Log.d("second", "works")
    }
}