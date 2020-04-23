package com.dolotdev.listotodo.di

import com.dolotdev.listotodo.di.module.DbModule
import com.dolotdev.listotodo.presentation.page.details.DetailsViewModel
import com.dolotdev.listotodo.presentation.page.list.ListToDoViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class
    ]
)
interface AppComponent {
    fun inject(into: ListToDoViewModel)
    fun inject(into: DetailsViewModel)
}