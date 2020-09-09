package com.test.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        final Calendar instance = Calendar.getInstance();
        final Date time = instance.getTime();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String timeStringType = simpleDateFormat.format(time);
        System.out.println(time);
        System.out.println(timeStringType);
        System.out.println(instance.get(Calendar.HOUR_OF_DAY)+"点");
    }
}
