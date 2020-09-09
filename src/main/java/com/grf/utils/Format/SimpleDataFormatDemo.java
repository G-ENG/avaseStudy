package com.grf.utils.Format;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * yyyy：年
 * MM：月
 * dd：日
 * hh：1~12小时制(1-12)
 * HH：24小时制(0-23)
 * mm：分
 * ss：秒
 * S：毫秒
 * E：星期几
 * D：一年中的第几天
 * F：一月中的第几个星期(会把这个月总共过的天数除以7)
 * w：一年中的第几个星期
 * W：一月中的第几星期(会根据实际情况来算)
 * a：上下午标识
 * k：和HH差不多，表示一天24小时制(1-24)。
 * K：和hh差不多，表示一天12小时制(0-11)。
 * z：表示时区
 */
public class SimpleDataFormatDemo {
    public static void main(String[] args) {
        String s1="现在的时间是：yyyy-MM-dd HH-mm-ss";
        String s2="现在的时间是：yyyy年MM月dd日，hh时mm分ss秒(a)";
        final SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(s1);
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(s2);
        final Date date = new Date();
        System.out.println("一般时间输出:" + date);
        System.out.println("时间戳:" + date.getTime());
        System.out.println("格式化输出 1 ：" + simpleDateFormat1.format(date));
        System.out.println("格式化输出 2 ：" + simpleDateFormat2.format(date));

    }

    @Test
    public void test() throws ParseException {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        final Date parse = simpleDateFormat.parse("1998-07-28 8:00");
        System.out.println(parse);
        System.out.println(parse.getTime());

    }
}
