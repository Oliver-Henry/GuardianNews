package com.example.guardiannews.ui.newsFeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guardiannews.model.NewsBase
import com.example.guardiannews.repository.NewsRepo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class NewsFeedViewModel @Inject constructor(private val newsRepo: NewsRepo) : ViewModel(){

    private val disposable = CompositeDisposable()
    val newsData = MutableLiveData<NewsBase>()
    val loading = MutableLiveData<Boolean>()

    fun fetchNews(){
        loading.value = true
        val networkCall = newsRepo.getNews().subscribe(
            {data->
                newsData.value = data
                loading.value = false
            },{
                it.printStackTrace()
                loading.value = false
            }
        )

        disposable.add(networkCall)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}