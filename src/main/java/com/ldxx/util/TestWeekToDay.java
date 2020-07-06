package com.ldxx.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestWeekToDay {

    // 根据year年的第week周，查询本周的起止时间
    public static String weekToDayFormate(int year, int week){
        Calendar calendar = Calendar.getInstance();
        // ①.设置该年份的开始日期：第一个月的第一天
        calendar.set(year,0,1);
        // ②.计算出第一周还剩几天：+1是因为1号是1天
        int dayOfWeek = 7 - calendar.get(Calendar.DAY_OF_WEEK) + 1;
        // ③.周数减去第一周再减去要得到的周
        week = week - 2;
        // ④.计算起止日期
        calendar.add(Calendar.DAY_OF_YEAR,week * 7 + dayOfWeek);
        String startTime=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        //System.out.println("开始日期：" + new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR, 6);
        String endTime=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        //System.out.println("结束日期：" + new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        return startTime+"~"+endTime;
    }
}
