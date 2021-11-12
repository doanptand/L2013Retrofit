package com.ddona.retrofit.network

import com.ddona.retrofit.model.Comment
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.*

interface CommentService {

    @GET("comments")
    fun getAllComment(): Call<List<Comment>>

    @GET("comments")
    suspend fun getAllCommentWithCoroutines(): List<Comment>

    @GET("comments")
    fun getAllCommentWithRx(): Observable<List<Comment>>

    @GET("post")
    fun getPost(
        @Query("userId") userId: Int,
        @Query("_sort") sortField: String,
        @Query("_order") sortType: String,
    )

    @GET("post/{id}/comments")
    fun getPostWithID(@Path("id") postId: Int)


    @POST("/add/comment")
    fun addComment(@Body comment: Comment)

}