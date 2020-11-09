package com.example.guardiannews.di

import com.example.guardiannews.di.newsFeed.NewsFeedFragmentBuilderModule
import com.example.guardiannews.di.newsFeed.NewsFeedModules
import com.example.guardiannews.di.newsFeed.NewsFeedScope
import com.example.guardiannews.di.newsFeed.NewsFragmentViewModelModule
import com.example.guardiannews.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @NewsFeedScope
    @ContributesAndroidInjector(
        modules = [
            NewsFeedFragmentBuilderModule::class,
            NewsFragmentViewModelModule::class,
            NewsFeedModules::class,
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}