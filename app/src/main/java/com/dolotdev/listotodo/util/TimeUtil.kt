package com.dolotdev.listotodo.util

object TimeUtil {

    fun getElapsedTime(startTime: Long): String {
        val timeDiff = (System.currentTimeMillis() - startTime) / 1000

        val days = timeDiff / (60 * 60 * 24)
        val hours = (timeDiff % (60 * 60 * 24)) / (60 * 60)
        val minutes = (timeDiff % (60 * 60)) / 60
        val seconds = timeDiff % 60

        return "${days}d ${hours}h ${minutes}m ${seconds}s"
    }
}