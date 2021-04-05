package com.fly.compontservice.http

import com.fly.compontservice.http.base.BaseRetrofitClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//todo  如果有多个baseUrl 如何处理呢
public object MainRetrofitClient {

    private const val BASE_URL = "https://wanandroid.com/"

    public val reqApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(initClient())
            .build()
        return@lazy retrofit.create(RequestService::class.java)
    }


    private fun initClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(getHeaderInterceptor())
            .addInterceptor(getInterceptor())
            .build()
    }


    private fun getHeaderInterceptor(): Interceptor {
        return Interceptor {
            val originRequest = it.request()
            val request = originRequest.newBuilder().addHeader("useId", "123").build()
            it.proceed(request)

        }
    }

    private fun getInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}
