package ru.zar1official.daggerfirstdemo.di

import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.domain.ReadDataUseCase
import ru.zar1official.daggerfirstdemo.domain.Repository
import ru.zar1official.daggerfirstdemo.domain.SaveDataUseCase

@Module
object DomainModule {
    @Provides
    fun provideReadDataUseCase(repository: Repository): ReadDataUseCase = ReadDataUseCase(repository = repository)

    @Provides
    fun provideSaveDataUseCase(repository: Repository): SaveDataUseCase = SaveDataUseCase(repository = repository)
}