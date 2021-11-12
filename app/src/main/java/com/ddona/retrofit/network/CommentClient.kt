package com.ddona.retrofit.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommentClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


    val header = Interceptor {
        val originRequest = it.request()

        val newRequest = originRequest.newBuilder()
            .header("Content-Type", "image/jpg")
            .header("User-Agent", "Chrome...")
            .build()
        it.proceed(newRequest)
    }

    val okHttp = OkHttpClient.Builder()
        .addInterceptor(header)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    operator fun invoke(): CommentService = retrofit.create(CommentService::class.java)

}