package com.dolotdev.listotodo.di.module

import android.content.Context
import com.dolotdev.listotodo.app.App
import com.dolotdev.listotodo.util.RandomColor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: App) {

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideColorRandom(context: Context) = RandomColor(context)

}