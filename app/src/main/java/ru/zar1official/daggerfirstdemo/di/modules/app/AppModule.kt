package ru.zar1official.daggerfirstdemo.di.modules.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [FactoryModule::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}
