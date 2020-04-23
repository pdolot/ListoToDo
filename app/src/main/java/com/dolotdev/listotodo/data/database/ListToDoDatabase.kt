package com.dolotdev.listotodo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dolotdev.listotodo.data.database.itemToDo.ItemToDoDao
import com.dolotdev.listotodo.data.model.ItemToDo

@Database(
    entities = [ItemToDo::class], version = 1
)
abstract class ListToDoDatabase : RoomDatabase() {

    abstract fun itemToDoDao(): ItemToDoDao
}