package ru.zar1official.daggerfirstdemo.data.logger

import android.util.Log
import javax.inject.Inject

class LoggerThirdImpl @Inject constructor() : Logger {
    override fun log() {
        Log.d("third", "works")
    }
}