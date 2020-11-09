package com.example.guardiannews.di

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.guardiannews.R
import com.example.guardiannews.network.ApiConfig
import com.example.guardiannews.network.GuardianAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object AppModules {

    @JvmStatic
    @Singleton
    @Provides
    fun provideAppContext(application: Application): Context {
        return application.applicationContext
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofitClient(): GuardianAPI {
        val clientBuilder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(interceptor)
        val client = clientBuilder.build()

        return Retrofit.Builder()
            .baseUrl(ApiConfig().getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(GuardianAPI::class.java)
    }
}