package com.dolotdev.listotodo.presentation.page.list

import androidx.lifecycle.viewModelScope
import com.dolotdev.listotodo.base.BaseViewModel
import com.dolotdev.listotodo.data.database.itemToDo.ItemToDoRepository
import com.dolotdev.listotodo.data.model.ItemToDo
import com.dolotdev.listotodo.di.Injector
import com.dolotdev.listotodo.util.NameGenerator
import com.dolotdev.listotodo.util.RandomColor
import kotlinx.coroutines.launch
import javax.inject.Inject


class ListToDoPageViewModel : BaseViewModel() {

    @Inject
    lateinit var itemToDoRepository: ItemToDoRepository

    @Inject
    lateinit var randomColor: RandomColor

    init {
        Injector.component.inject(this)
    }

    fun deleteItem(id: Long) = viewModelScope.launch {
        itemToDoRepository.deleteItem(id)
    }

    fun addItem() {
        val item = ItemToDo(
            name = "Rzecz do zrobienia - ${NameGenerator.generateName(8)}",
            creationDate = System.currentTimeMillis(),
            clickCounter = 0,
            color = randomColor.getRandomColor()
        )
        insertItem(item)
    }

    fun incrementClickCounter(id: Long) = viewModelScope.launch {
        itemToDoRepository.incrementClickCounter(id)
    }

    private fun insertItem(item: ItemToDo) = viewModelScope.launch {
        itemToDoRepository.insert(item)
    }
}