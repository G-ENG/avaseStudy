package com.test.timeStamp;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class TimeStampTest {
    @Test
    public void testTimeStamp() throws ParseException {
        LocalDateTime sTime = LocalDateTime.of(2020, 3, 27, 8, 0,0,0);
        long lsTime = sTime.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(lsTime);
        String s = "2020-3-27 8:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(simpleDateFormat.parse(s).getTime());

        LocalDateTime eTime = LocalDateTime.of(2020, 3, 27, 12, 0);
        long leTime = eTime.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(leTime);

        LocalDateTime Time = LocalDateTime.of(1998, 7, 28, 8, 0);
        long lTime = Time.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(lTime);


        String s1="2020-3-28 10:00";
        System.out.println(simpleDateFormat.parse(s1).getTime());
    }
}
