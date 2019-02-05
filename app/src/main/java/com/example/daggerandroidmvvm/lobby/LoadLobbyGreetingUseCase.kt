package com.example.daggerandroidmvvm.lobby

import com.example.daggerandroidmvvm.common.domain.interactors.LoadGreetingUseCase
import io.reactivex.Single
import javax.inject.Inject

class LoadLobbyGreetingUseCase
@Inject constructor(private val greetingRepository: LobbyGreetingRepository) : LoadGreetingUseCase {

    override fun execute(): Single<String> {
        return greetingRepository.greeting
    }
}
