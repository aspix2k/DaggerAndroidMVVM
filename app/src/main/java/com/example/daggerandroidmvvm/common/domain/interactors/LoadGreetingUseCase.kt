package com.example.daggerandroidmvvm.common.domain.interactors

import io.reactivex.Single

interface LoadGreetingUseCase {
    fun execute(): Single<String>
}
