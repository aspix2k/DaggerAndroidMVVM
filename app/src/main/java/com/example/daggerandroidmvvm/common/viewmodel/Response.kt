package com.example.daggerandroidmvvm.common.viewmodel

import com.example.daggerandroidmvvm.common.viewmodel.Status.*

/**
 * Response holder provided to the UI
 */
class Response private constructor(val status: Status, val data: String?, val error: Throwable?) {

    companion object {

        fun loading(): Response {
            return Response(LOADING, null, null)
        }

        fun success(data: String): Response {
            return Response(SUCCESS, data, null)
        }

        fun error(error: Throwable): Response {
            return Response(ERROR, null, error)
        }
    }
}
