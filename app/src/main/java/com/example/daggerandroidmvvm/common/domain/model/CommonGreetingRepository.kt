package com.example.daggerandroidmvvm.common.domain.model

import io.reactivex.Single
import java.util.concurrent.TimeUnit

class CommonGreetingRepository {
    val greeting: Single<String>
        get() = Single.just("Hello from CommonGreetingRepository")
                .delay(400, TimeUnit.MILLISECONDS)
}
