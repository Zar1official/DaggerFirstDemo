package ru.zar1official.daggerfirstdemo.di.data

import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.Logger
import ru.zar1official.daggerfirstdemo.data.LoggerFirstImpl
import ru.zar1official.daggerfirstdemo.data.LoggerSecondImpl
import ru.zar1official.daggerfirstdemo.data.LoggerThirdImpl
import ru.zar1official.daggerfirstdemo.di.data.qualifiers.ThirdLoggerQualifier
import javax.inject.Named

@Module
object LoggerModule {

    @Named("first_logger")
    @Provides
    fun provideFirstLogger(): Logger = LoggerFirstImpl()

    @Named("second_logger")
    @Provides
    fun provideSecondLogger(): Logger = LoggerSecondImpl()

    @ThirdLoggerQualifier
    @Provides
    fun provideThirdLogger(): Logger = LoggerThirdImpl()
}