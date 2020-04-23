package com.dolotdev.listotodo.data.database.itemToDo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dolotdev.listotodo.data.model.ItemToDo
import io.reactivex.Single

@Dao
interface ItemToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemToDo: ItemToDo)

    @Query("SELECT * FROM ItemToDo")
    fun getAll(): LiveData<List<ItemToDo>>

    @Query("SELECT * FROM ItemToDo WHERE id = :id")
    fun getItemById(id: Long): Single<ItemToDo>

    @Query("UPDATE ItemToDo SET clickCounter = clickCounter + 1 WHERE id = :id")
    fun incrementClickCounter(id: Long)

    @Query("DELETE FROM ItemToDo WHERE id = :id")
    suspend fun deleteItem(id: Long)
}