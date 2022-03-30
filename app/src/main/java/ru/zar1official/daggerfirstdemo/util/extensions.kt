package ru.zar1official.daggerfirstdemo.util

import android.content.Context
import ru.zar1official.daggerfirstdemo.app.App
import ru.zar1official.daggerfirstdemo.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }