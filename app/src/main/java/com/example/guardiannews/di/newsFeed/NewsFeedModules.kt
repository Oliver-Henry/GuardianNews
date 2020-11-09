package com.example.guardiannews.di.newsFeed

import com.example.guardiannews.ui.newsFeed.NewsFeedAdapter
import dagger.Module
import dagger.Provides

@Module
object NewsFeedModules {

    @JvmStatic
    @NewsFeedScope
    @Provides
    fun getNewsFeedAdapter(): NewsFeedAdapter {
        return NewsFeedAdapter()
    }
}