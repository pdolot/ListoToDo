package com.dolotdev.listotodo.util

import java.lang.StringBuilder
import java.security.SecureRandom

object NameGenerator {
    private val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    fun generateName(length: Int): String{
        val random = SecureRandom()
        val letters = ArrayList<Char>()
        for (i in 0 until length){
            letters.add(alphabet[random.nextInt(alphabet.length)])
        }

        val sb = StringBuilder()
        letters.apply {
            shuffle()
            forEach {
                sb.append(it)
            }
        }

        return sb.toString()
    }
}