package com.example.daggerandroidmvvm.common.domain.interactors

import com.example.daggerandroidmvvm.common.domain.model.CommonGreetingRepository
import io.reactivex.Single
import javax.inject.Inject

class LoadCommonGreetingUseCase
@Inject constructor(private val greetingRepository: CommonGreetingRepository) : LoadGreetingUseCase {

    override fun execute(): Single<String> {
        return greetingRepository.greeting
    }
}
