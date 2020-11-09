package com.example.guardiannews

import com.example.guardiannews.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder()
            .applicationBind(this)
            .contextBind(this)
            .build()
    }

}