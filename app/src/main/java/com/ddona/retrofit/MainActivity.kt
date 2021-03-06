package com.ddona.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.ddona.retrofit.model.Comment
import com.ddona.retrofit.network.CommentClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        lifecycleScope.launch(Dispatchers.IO) {
//            val response = CommentClient.invoke().getAllComment().execute()
//            if (response.isSuccessful) {
//                val comments = response.body()
//                comments?.let {
//                    for (i in 0 until comments.size) {
//                        Log.d("doanpt", "${comments[i]}")
//                    }
//                }
//            }
//        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            val comments = CommentClient.invoke().getAllCommentWithCoroutines()
//            for (comment in comments) {
//                Log.d("doanpt", "$comment")
//            }
//        }


        val comments = CommentClient.invoke()
            .getAllCommentWithRx()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { list -> Observable.fromIterable(list) }
            .filter { it.id % 2 == 0 }
            .toList()
            .subscribe()

//        CommentClient.invoke().getPost(10, "id", "desc")


        //enter queue: FIFO
//        val comments = arrayListOf<Comment>()
////
//        CommentClient.invoke().getAllComment().enqueue(
//            object : Callback<List<Comment>> {
//                override fun onResponse(
//                    call: Call<List<Comment>>,
//                    response: Response<List<Comment>>
//                ) {
//                    if (response.isSuccessful) {
//                        response.body()?.let {
//                            comments.addAll(response.body() as List<Comment>)
//                            Log.d("doanpt", "get comment in response: ${comments.size}")
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                }
//            }
//        )
//        Log.d("doanpt", "get comment: ${comments.size}")
    }
}