package com.example.daggerandroidmvvm.common.domain.model

import io.reactivex.Single

class CommonGreetingRepository {
    val greeting: Single<String>
        get() = Single.just("Hello from CommonGreetingRepository")
}
