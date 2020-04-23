package com.dolotdev.listotodo.di

import com.dolotdev.listotodo.app.App
import com.dolotdev.listotodo.di.module.AppModule
import com.dolotdev.listotodo.di.module.DbModule

object Injector {
    lateinit var component: AppComponent

    fun init(application: App) {
        component = DaggerAppComponent.builder()
            .dbModule(DbModule(application))
            .appModule(AppModule(application))
            .build()
    }
}