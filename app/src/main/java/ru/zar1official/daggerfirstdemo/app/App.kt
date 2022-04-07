package ru.zar1official.daggerfirstdemo.app

import android.app.Application
import ru.zar1official.daggerfirstdemo.di.components.*
import ru.zar1official.daggerfirstdemo.di.modules.app.AppModule
import ru.zar1official.daggerfirstdemo.di.modules.firstscreen.FirstScreenModule
import ru.zar1official.daggerfirstdemo.di.modules.secondscreen.SecondScreenModule
import ru.zar1official.daggerfirstdemo.di.modules.thirdscreen.ThirdScreenModule

class App : Application() {
    lateinit var appComponent: AppComponent
        private set
    var thirdScreenComponent: ThirdScreenComponent? = null
        private set
    var firstScreenComponent: FirstScreenComponent? = null
        private set
    var secondScreenComponent: SecondScreenComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }

    fun initThirdScreenComponent() {
        if (thirdScreenComponent == null) {
            thirdScreenComponent = appComponent.plusThirdScreenComponent(ThirdScreenModule())
        }
    }

    fun initFirstScreenComponent() {
        if (firstScreenComponent == null) {
            firstScreenComponent = appComponent.plusFirstScreenComponent(FirstScreenModule())
        }
    }

    fun initSecondScreenComponent() {
        if (secondScreenComponent == null) {
            secondScreenComponent = appComponent.plusSecondScreenComponent(SecondScreenModule())
        }
    }

    fun clearThirdScreenComponent() {
        thirdScreenComponent = null
    }
}