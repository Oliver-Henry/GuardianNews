package com.example.guardiannews.repository

import com.example.guardiannews.model.NewsBase
import com.example.guardiannews.network.GuardianAPI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.http.Query
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val guardianAPI: GuardianAPI) : NewsRepo {
    override fun getNews(): Single<NewsBase> {
        return guardianAPI
            .getNews(
                apiKey,
                orderBy,
                showFields
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    companion object{
        const val apiKey: String = "c79b57d7-4705-4b74-aa32-8dab8285c5aa"
        const val orderBy: String = "newest"
        const val showFields: String = "headline,trailText,thumbnail,body"
    }
}