package com.example.daggerandroidmvvm.lobby

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.daggerandroidmvvm.common.domain.interactors.LoadCommonGreetingUseCase
import com.example.daggerandroidmvvm.rx.SchedulersFacade

class LobbyViewModelFactory(
        private val loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
        private val loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
        private val schedulersFacade: SchedulersFacade) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LobbyViewModel::class.java)) {
            return LobbyViewModel(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
