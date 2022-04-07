package ru.zar1official.daggerfirstdemo.di.modules.app

import dagger.Binds
import dagger.Module
import ru.zar1official.daggerfirstdemo.data.logger.Logger
import ru.zar1official.daggerfirstdemo.data.logger.LoggerFirstImpl
import ru.zar1official.daggerfirstdemo.data.logger.LoggerSecondImpl
import ru.zar1official.daggerfirstdemo.data.logger.LoggerThirdImpl
import ru.zar1official.daggerfirstdemo.di.qualifiers.ThirdLoggerQualifier
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