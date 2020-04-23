package com.dolotdev.listotodo.app

import android.app.Application
import com.dolotdev.listotodo.di.Injector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}