package com.example.guardiannews.network

import com.example.guardiannews.model.NewsBase
import com.example.guardiannews.network.ApiConfig.Companion.baseUrl
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GuardianAPI {

    @GET("/search")
    fun getNews(
        @Query("api-key") apiKey: String,
        @Query("order-by") orderBy: String,
        @Query("show-fields") showFields: String,
    ): Single<NewsBase>

}