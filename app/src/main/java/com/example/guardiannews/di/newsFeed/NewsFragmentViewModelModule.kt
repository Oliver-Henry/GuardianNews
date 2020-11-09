package com.example.guardiannews.di.newsFeed

import androidx.lifecycle.ViewModel
import com.example.guardiannews.di.ViewModelKey
import com.example.guardiannews.ui.newsFeed.NewsFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsFragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    abstract fun bindProfileViewModel(newsFeedViewModel: NewsFeedViewModel): ViewModel
}