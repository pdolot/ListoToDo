package com.dolotdev.listotodo.util

object TimeUtil {

    fun getElapsedTime(startTime: Long): String {
        val timeDiff = (System.currentTimeMillis() - startTime) / 1000

        var days = timeDiff / (60 * 60 * 24)
        var hours = (timeDiff % (60 * 60 * 24)) / (60 * 60)
        var minutes = (timeDiff % (60 * 60)) / 60
        var seconds = timeDiff % 60

        return "${days}d ${hours}h ${minutes}m ${seconds}s"
    }
}