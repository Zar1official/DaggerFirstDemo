package ru.zar1official.daggerfirstdemo.app

import android.app.Application
import ru.zar1official.daggerfirstdemo.di.app.AppModule
import ru.zar1official.daggerfirstdemo.di.app.ThirdScreenModule
import ru.zar1official.daggerfirstdemo.di.components.AppComponent
import ru.zar1official.daggerfirstdemo.di.components.DaggerAppComponent
import ru.zar1official.daggerfirstdemo.di.components.ThirdScreenComponent

class App : Application() {
    lateinit var appComponent: AppComponent
        private set
    var thirdScreenComponent: ThirdScreenComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }

    fun initThirdScreenComponent() {
        if(thirdScreenComponent == null){
            thirdScreenComponent = appComponent.plusThirdScreenComponent(ThirdScreenModule())
        }
    }

    fun clearThirdScreenComponent() {
        thirdScreenComponent = null
    }
}