package com.example.daggerandroidmvvm.lobby

import io.reactivex.Single
import java.util.concurrent.TimeUnit

class LobbyGreetingRepository {
    val greeting: Single<String>
        get() = Single.just("Hello from LobbyGreetingRepository")
                .delay(1000, TimeUnit.MILLISECONDS)
}
