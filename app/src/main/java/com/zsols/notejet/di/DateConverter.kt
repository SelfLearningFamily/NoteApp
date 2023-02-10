package com.zsols.notejet.di

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimestamp(dateLong : Long) : Date{
        return  Date(dateLong)
    }

    @TypeConverter
    fun toTimestamp(date : Date) : Long{
        return date.time
    }
}