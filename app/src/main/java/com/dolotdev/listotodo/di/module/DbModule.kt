package com.dolotdev.listotodo.di.module

import androidx.room.Room
import com.dolotdev.listotodo.app.App
import com.dolotdev.listotodo.data.database.ListToDoDatabase
import com.dolotdev.listotodo.data.database.itemToDo.ItemToDoDao
import com.dolotdev.listotodo.data.database.itemToDo.ItemToDoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule(private val application: App) {

    @Singleton
    @Provides
    fun provideRoomDatabase(): ListToDoDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            ListToDoDatabase::class.java,
            "ListToDoDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun provideItemToDoDao(database: ListToDoDatabase): ItemToDoDao{
        return database.itemToDoDao()
    }

    @Singleton
    @Provides
    fun provideItemToDoRepository(itemToDoDao: ItemToDoDao): ItemToDoRepository{
        return ItemToDoRepository(itemToDoDao)
    }

}