package com.example.daggerandroidmvvm.di

import com.example.daggerandroidmvvm.lobby.LobbyActivity
import com.example.daggerandroidmvvm.lobby.LobbyModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Binds all sub-components within the app.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [LobbyModule::class])
    abstract fun bindLobbyActivity(): LobbyActivity

    // Add bindings for other sub-components here
}
