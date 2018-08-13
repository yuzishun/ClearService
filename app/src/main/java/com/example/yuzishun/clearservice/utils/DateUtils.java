package com.example.yuzishun.clearservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by yuzishun on 2018/8/12.
 */

public class DateUtils {

    private static String mYear; // 当前年
    private static String mMonth; // 月
    private static String mDay;
    private static String mWay;


    /**
     * 获取当前日期几月几号
     */
    public static String getDateString() {

        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        return mMonth + "月" + mDay + "日";
    }

    /**
     * 获取当前年月日
     *
     * @return
     */
    public static String StringData() {

        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        return mYear + "-" + mMonth + "-" + mDay;
    }

    /**
     * 获取当前是周几
     */
    public static String getWeekString() {
        final Calendar c = Calendar.getInstance();
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "周天";
        } else if ("2".equals(mWay)) {
            mWay = "周一";
        } else if ("3".equals(mWay)) {
            mWay = "周二";
        } else if ("4".equals(mWay)) {
            mWay = "周三";
        } else if ("5".equals(mWay)) {
            mWay = "周四";
        } else if ("6".equals(mWay)) {
            mWay = "周五";
        } else if ("7".equals(mWay)) {
            mWay = "周六";
        }
        return mDay;
    }

    /**
     * 根据当前日期获得是星期几
     *
     * @return
     */
    public static String getWeek(String time) {
        String Week = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {

            c.setTime(format.parse(time));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }
        return Week;
    }

    /**
     * 获取今天往后一周的日期（年-月-日）
     */
    public  List<String> get7date() {
        List<String> dates = new ArrayList<String>();
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String date = sim.format(c.getTime());
        dates.add(date);
        for (int i = 0; i < 6; i++) {
            c.add(Calendar.DAY_OF_MONTH, 1);
            date = sim.format(c.getTime());
            dates.add(date);

        }
        return dates;

    }
        /**
         * 获取今天往后一周的日期（几月几号）
         */
        public  List<String> getSevendate () {
            List<String> dates = new ArrayList<String>();
            final Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

            for (int i = 0; i < 7; i++) {
                mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
                mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
                mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + i);// 获取当前日份的日期号码
                String date = mMonth + "/" + mDay ;
                dates.add(date);
            }
            return dates;
        }
        /**
         * 获取今天往后一周的集合
         */
        public  List<String> get7week () {
            String week = "";
            List<String> weeksList = new ArrayList<String>();
            List<String> dateList = get7date();
            for (String s : dateList) {
                if (s.equals(StringData())) {
                    week = "今天";
                } else {
                    week = getWeek(s);
                }
                weeksList.add(week);
            }
            return weeksList;
        }

        /**
         * 判断当前日期是否为今天
         */

    public static boolean isToday(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if (param.equals(now)) {
            return true;
        }
        return false;
    }

    /**
     * 获取今天往后一天的日期（时间戳）
     * 时间戳 增加24小时
     */
    public static long getNextDate(long time) {
        long date = time + 24 * 60 * 60 * 1000;
        return date;
    }

    /**
     * 获取今天往前一天的日期（时间戳）
     */
    public static long getBeforeDate(long time) {
        long date = time - 23 * 60 * 60 * 1000;
        return date;
    }





}
