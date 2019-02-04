package com.example.daggerandroidmvvm.lobby

import com.example.daggerandroidmvvm.common.domain.interactors.LoadCommonGreetingUseCase
import com.example.daggerandroidmvvm.rx.SchedulersFacade

import dagger.Module
import dagger.Provides

/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
class LobbyModule {

    @Provides
    fun provideLobbyGreetingRepository(): LobbyGreetingRepository {
        return LobbyGreetingRepository()
    }

    @Provides
    fun provideLobbyViewModelFactory(
            loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
            loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
            schedulersFacade: SchedulersFacade): LobbyViewModelFactory {
        return LobbyViewModelFactory(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade)
    }
}
