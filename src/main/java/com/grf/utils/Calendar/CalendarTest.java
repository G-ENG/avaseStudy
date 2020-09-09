package com.grf.utils.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) {
        final Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.DATE)+"---哪一天");
        System.out.println(instance.get(Calendar.MONTH) + "月");
        System.out.println("一周第"+instance.get(Calendar.DAY_OF_WEEK)+"天");
        System.out.println(instance.get(Calendar.HOUR)+"点---12小时制");
        System.out.println(instance.get(Calendar.HOUR_OF_DAY)+"点---24小时制");

        System.out.println("时区："+instance.getTimeZone());
        System.out.println(instance.getTime());
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("格式化之后的时间："+simpleDateFormat.format(instance.getTime()));
        System.out.println(instance.getTimeInMillis());

        instance.add(Calendar.DATE,1);
        System.out.println("增加一天："+instance.getTime());
        System.out.println("增加一天："+instance.get(Calendar.DATE));

        instance.add(Calendar.MONTH,1);
        System.out.println("增加一个月："+instance.getTime());

        final Calendar instance1 = Calendar.getInstance();
        instance1.set(1998, Calendar.AUGUST,28);
        System.out.println("生日:"+instance1.getTime());

        String ans;
        ans= instance.before(instance1) ?"对":"错";
        System.out.println("日期1在生日之前？"+ans);

    }
}
