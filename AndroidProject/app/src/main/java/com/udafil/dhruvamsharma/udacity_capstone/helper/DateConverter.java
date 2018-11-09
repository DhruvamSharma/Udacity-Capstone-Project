package com.udafil.dhruvamsharma.udacity_capstone.helper;

import java.util.Date;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timeStamp) {
        return timeStamp == null ? null : new Date(timeStamp);
    }

    @TypeConverter
    public static Long toTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }

}