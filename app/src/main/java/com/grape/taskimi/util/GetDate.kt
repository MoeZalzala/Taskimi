package com.grape.taskimi.util

import java.text.DateFormat.getDateInstance
import java.text.SimpleDateFormat
import java.util.*

object GetDate {
    fun getCurrentDate(): String {
        val date = Date()
        val dateFormatter = getDateInstance()
        return (dateFormatter.format(date).toString())
    }
}