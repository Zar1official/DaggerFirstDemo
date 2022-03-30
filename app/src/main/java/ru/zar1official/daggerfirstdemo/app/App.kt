package ru.zar1official.daggerfirstdemo.app

import android.app.Application
import ru.zar1official.daggerfirstdemo.di.AppComponent
import ru.zar1official.daggerfirstdemo.di.AppModule
import ru.zar1official.daggerfirstdemo.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context =this )).build()
    }
}