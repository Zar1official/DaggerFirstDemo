package ru.zar1official.daggerfirstdemo.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.di.app.FactoryModule
import javax.inject.Singleton

@Module(includes = [FactoryModule::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}
