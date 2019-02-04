package com.example.daggerandroidmvvm.di

import com.example.daggerandroidmvvm.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    /* Use AndroidInjectionModule.class if you're not using support library */
    AndroidSupportInjectionModule::class, AppModule::class, BuildersModule::class])
interface AppComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
