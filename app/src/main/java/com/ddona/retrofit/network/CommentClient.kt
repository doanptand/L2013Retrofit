package com.ddona.retrofit.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommentClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    operator fun invoke(): CommentService = retrofit.create(CommentService::class.java)

}