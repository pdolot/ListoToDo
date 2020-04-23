package com.dolotdev.listotodo.di

import com.dolotdev.listotodo.di.module.AppModule
import com.dolotdev.listotodo.di.module.DbModule
import com.dolotdev.listotodo.presentation.page.details.DetailsPageViewModel
import com.dolotdev.listotodo.presentation.page.list.ListToDoPageViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(into: ListToDoPageViewModel)
    fun inject(into: DetailsPageViewModel)
}