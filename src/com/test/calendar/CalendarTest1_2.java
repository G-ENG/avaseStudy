package com.test.calendar;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class CalendarTest1_2 {
    public static void main(String[] args) {
         Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(1000);
        System.out.println(instance.getTime());
         Calendar instance1 = Calendar.getInstance();

        System.out.println(instance1.getTime());
    }

    public static final Logger LOG = LoggerFactory.getLogger(CalendarTest1_2.class);

    @Test
    public void test(){
        LOG.info("hello info");
        LOG.warn("hello warn");
        LOG.error("hello error");
    }
}
