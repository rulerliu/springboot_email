package com.example.email.hutool;

import cn.hutool.core.date.*;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
    }

    private static void test11() {
        //年龄
        System.out.println(DateUtil.ageOfNow("1996-11-16"));

        //是否闰年
        DateUtil.isLeapYear(2017);

    }

    private static void test10() {
        System.out.println("星座和属相");
        // "摩羯座"
        String zodiac = DateUtil.getZodiac(Month.JANUARY.getValue(), 19);

        // "狗"
        String chineseZodiac = DateUtil.getChineseZodiac(1994);

    }

    private static void test9() {
        System.out.println("计时器");
        TimeInterval timer = DateUtil.timer();

        //---------------------------------
        //-------这是执行过程
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //---------------------------------

        System.out.println(timer.interval());//花费毫秒数

        timer.intervalRestart();//返回花费时间，并重置开始时间
        //-------这是执行过程
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(timer.intervalMinute());//花费分钟数

    }

    private static void test8() {
        System.out.println("两个日期之间的时间差");
        String dateStr1 = "2021-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2021-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        long betweenDay1 = DateUtil.between(date1, date2, DateUnit.WEEK);
        System.out.println(betweenDay1);
        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
        long between2 = DateUtil.between(date1, date2, DateUnit.HOUR);
        System.out.println(between2);

        //Level.MINUTE表示精确到分
        String formatBetween = DateUtil.formatBetween(between2, BetweenFormatter.Level.MINUTE);
        System.out.println(formatBetween);
    }

    private static void test7() {
        System.out.println("针对当前时间，提供了简化的偏移方法（例如昨天、上周、上个月等）：");
        //昨天
        System.out.println(DateUtil.yesterday());
        //明天
        System.out.println(DateUtil.tomorrow());
        //上周
        System.out.println(DateUtil.lastWeek());
        //下周
        System.out.println(DateUtil.nextWeek());
        //上个月
        System.out.println(DateUtil.lastMonth());
        //下个月
        System.out.println(DateUtil.nextMonth());
    }

    private static void test6() {
        System.out.println("日期时间偏移");
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        //结果：2017-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);

        //常用偏移，结果：2017-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(date, 3);

        //常用偏移，结果：2017-03-01 19:33:23
        DateTime newDate3 = DateUtil.offsetHour(date, -3);

    }

    private static void test5() {
        System.out.println("开始和结束时间");
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);

        System.out.println(DateUtil.beginOfMonth(date));
        System.out.println(DateUtil.endOfMonth(date));
        System.out.println(DateUtil.beginOfWeek(date, true));
        System.out.println(DateUtil.beginOfYear(date));

    }

    private static void test4() {
        System.out.println("获取Date对象的某个部分");
        Date date = DateUtil.date();
        //获得年的部分
        DateUtil.year(date);
        //获得月份，从0开始计数
        DateUtil.month(date);
        System.out.println(DateUtil.dayOfYear(date));
        System.out.println(DateUtil.dayOfMonth(date));
        System.out.println(DateUtil.dayOfWeek(date));
        //获得月份枚举
        Month month = DateUtil.monthEnum(date);
        System.out.println(month);
        //.....

    }

    private static void test3() {
        System.out.println("格式化日期输出");
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println(format);
        String format2 = DateUtil.format(date, DatePattern.PURE_DATETIME_PATTERN);
        System.out.println(format2);

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);
        String formatDateTime2 = DateUtil.format(date, DatePattern.NORM_DATETIME_FORMAT);
        System.out.println(formatDateTime);
        System.out.println(formatDateTime2);

        String date3 = DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_PATTERN);
        System.out.println(date3);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);

    }

    private static void test2() {
        System.out.println("2===字符串转日期");
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        String dateStr2 = "2017-03-01 14:44:33";
        Date date2 = DateUtil.parse(dateStr2, DatePattern.NORM_DATETIME_FORMAT);
        System.out.println(date2);
    }

    private static void test1() {
        System.out.println("1===Date、long、Calendar之间的相互转换");
        //当前时间
        Date date = DateUtil.date();
        System.out.println(date);
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
    }

}
