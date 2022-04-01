package ru.zar1official.daggerfirstdemo.data

import android.util.Log

class LoggerThirdImpl: Logger {
    override fun log() {
        Log.d("third", "works")
    }
}