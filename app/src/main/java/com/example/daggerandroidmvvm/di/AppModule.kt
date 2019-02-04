package com.example.daggerandroidmvvm.di

import android.content.Context
import com.example.daggerandroidmvvm.App
import com.example.daggerandroidmvvm.common.domain.model.CommonGreetingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideCommonHelloService(): CommonGreetingRepository {
        return CommonGreetingRepository()
    }
}
