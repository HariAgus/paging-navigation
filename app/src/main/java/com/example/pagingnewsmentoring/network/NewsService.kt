package com.example.pagingnewsmentoring.network

import com.example.pagingnewsmentoring.model.FeedNews
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    fun getNews(
        @Query("q") keyword: String,
        @Query("apikey") api: String,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): Flowable<FeedNews>

}