package com.example.guardiannews.di

import com.example.guardiannews.network.GuardianAPI
import com.example.guardiannews.repository.NewsRepo
import com.example.guardiannews.repository.NewsRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun getNewsRepo(guardianAPI: GuardianAPI): NewsRepo {
        return NewsRepoImpl(guardianAPI)
    }
}