package com.dolotdev.listotodo.data.database.itemToDo

import androidx.lifecycle.LiveData
import com.dolotdev.listotodo.data.model.ItemToDo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ItemToDoRepository(private val itemToDoDao: ItemToDoDao) {

    suspend fun insert(itemToDo: ItemToDo) {
        itemToDoDao.insert(itemToDo)
    }

    fun getAll(): LiveData<List<ItemToDo>> {
        return itemToDoDao.getAll()
    }

    fun getItemById(id: Long): Single<ItemToDo> {
        return itemToDoDao.getItemById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    suspend fun incrementClickCounter(id: Long) {
        return itemToDoDao.incrementClickCounter(id)
    }

    suspend fun deleteItem(id: Long) {
        return itemToDoDao.deleteItem(id)
    }

}