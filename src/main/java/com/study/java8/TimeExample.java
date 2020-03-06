package com.study.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExample {
    public static void main(String[] args) {
        TimeExample timeExample = new TimeExample();
        timeExample.testLocalDateTime();
    }

    private void testLocalDateTime() {
        //获取当前的日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        LocalDate localDate = now.toLocalDate();
        System.out.println("date1:" + localDate);

        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        int second = now.getSecond();
        System.out.println("月："+ month+",日：" + dayOfMonth + ", 秒" +second);

        // 12 december 2014
        LocalDate of = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3:"+ of);

        //12 小时 15 分钟
        LocalTime date4 = LocalTime.of(12, 15);
        System.out.println("date4:"+date4);

        //解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

    }
}
