package com.dolotdev.listotodo.util

import android.content.Context
import com.dolotdev.listotodo.R
import java.security.SecureRandom

class RandomColor(context: Context) {

    private val colors = context.resources.getIntArray(R.array.itemBgColors).toList()

    fun getRandomColor(): Int {
        val random = SecureRandom()
        return colors[random.nextInt(colors.size)]
    }
}