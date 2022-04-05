package ru.zar1official.daggerfirstdemo.util

import android.content.Context
import ru.zar1official.daggerfirstdemo.app.App
import ru.zar1official.daggerfirstdemo.di.components.AppComponent
import ru.zar1official.daggerfirstdemo.di.components.ThirdScreenComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }

val Context.thirdScreenComponent: ThirdScreenComponent?
    get()  = when(this){
        is App -> thirdScreenComponent
        else -> this.applicationContext.thirdScreenComponent
    }