package com.ddona.retrofit.network

import com.ddona.retrofit.model.Comment
import retrofit2.Call
import retrofit2.http.GET

interface CommentService {

    @GET("comments")
    fun getAllComment(): Call<List<Comment>>

    @GET("comments")
    suspend fun getAllCommentWithCoroutines(): List<Comment>

}