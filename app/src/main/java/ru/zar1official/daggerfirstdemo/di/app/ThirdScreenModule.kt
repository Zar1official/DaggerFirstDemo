package ru.zar1official.daggerfirstdemo.di.app

import dagger.Module
import dagger.Provides
import ru.zar1official.daggerfirstdemo.data.A
import ru.zar1official.daggerfirstdemo.data.B
import ru.zar1official.daggerfirstdemo.di.scopes.ThirdScreenScope

@Module
class ThirdScreenModule {
    @ThirdScreenScope
    @Provides
    fun provideA(): A {
        return A()
    }

    @ThirdScreenScope
    @Provides
    fun provideB(): B {
        return B()
    }
}