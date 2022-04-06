package ru.zar1official.daggerfirstdemo.di.data

import dagger.Binds
import dagger.Module
import ru.zar1official.daggerfirstdemo.data.Logger
import ru.zar1official.daggerfirstdemo.data.LoggerFirstImpl
import ru.zar1official.daggerfirstdemo.data.LoggerSecondImpl
import ru.zar1official.daggerfirstdemo.data.LoggerThirdImpl
import ru.zar1official.daggerfirstdemo.di.data.qualifiers.ThirdLoggerQualifier
import javax.inject.Named

@Module
abstract class LoggerModule {
    @Named("first_logger")
    @Binds
    abstract fun bindFirstLogger(logger: LoggerFirstImpl): Logger

    @Named("second_logger")
    @Binds
    abstract fun bindSecondLogger(logger: LoggerSecondImpl): Logger

    @ThirdLoggerQualifier
    @Binds
    abstract fun bindThirdLogger(logger: LoggerThirdImpl): Logger
}