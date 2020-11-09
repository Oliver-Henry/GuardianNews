package com.example.guardiannews.di.newsFeed

import com.bumptech.glide.RequestManager
import com.example.guardiannews.ui.newsFeed.NewsFeedFragment
import com.example.guardiannews.viewModel.ViewModelFactory
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsFeedFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeNewsFeedFragment(): NewsFeedFragment
}