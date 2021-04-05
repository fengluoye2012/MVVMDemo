package com.fly.compontservice.http.base

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseRetrofitClient {
    open fun <S> getService(services: Class<S>, baseUrl: String): S {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            //.client()
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory()
            .build()
            .create(services)
    }
}