package com.example.guardiannews.di

import android.content.Context
import com.example.guardiannews.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModules::class,
        RepositoriesModule::class,
        ViewModelFactoryModule::class,
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationBind(app: App): Builder

        @BindsInstance
        fun contextBind(context: Context): Builder

        fun build(): AppComponent
    }
}