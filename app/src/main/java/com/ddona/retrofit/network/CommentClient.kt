package com.ddona.retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommentClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    operator fun invoke(): CommentService = retrofit.create(CommentService::class.java)

}