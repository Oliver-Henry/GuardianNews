package com.example.guardiannews.repository

import com.example.guardiannews.model.NewsBase
import io.reactivex.Single

interface NewsRepo {
    fun getNews(): Single<NewsBase>
}