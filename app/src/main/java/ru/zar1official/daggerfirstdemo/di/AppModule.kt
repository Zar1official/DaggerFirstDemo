package ru.zar1official.daggerfirstdemo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.domain.ReadDataUseCase
import ru.zar1official.daggerfirstdemo.domain.SaveDataUseCase
import ru.zar1official.daggerfirstdemo.presentation.factories.FirstFragmentViewModelFactory
import ru.zar1official.daggerfirstdemo.presentation.factories.SecondFragmentViewModelFactory
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideFirstViewModelFactory(
        saveDataUseCase: SaveDataUseCase
    ) =
        FirstFragmentViewModelFactory(
            saveDataUseCase = saveDataUseCase
        )

    @Provides
    fun provideSecondViewModelFactory(readDataUseCase: ReadDataUseCase): SecondFragmentViewModelFactory =
        SecondFragmentViewModelFactory(readDataUseCase = readDataUseCase)
}