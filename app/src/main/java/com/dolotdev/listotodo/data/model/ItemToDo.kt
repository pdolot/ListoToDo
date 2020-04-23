package com.dolotdev.listotodo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val creationDate: Long,
    val clickCounter: Int = 0,
    val color: Int = 0
)