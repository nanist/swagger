package com.ypk.swagger.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils * @Description TODO
 * @Author lgn
 * @Date 10:04 2022/8/21
 * @Version 1.0
 **/
public class LGSDateUtils {

    /**
     * 获取当前系统时间的前 N 天时间
     * @param currentdate
     * @return Date
     * @version: 1.0
     * @return
     */
    public static String getBefore_n_Day(Date currentdate,int n) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentdate);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        currentdate = calendar.getTime();
        String dayTime=format.format(currentdate);
        return dayTime;
    }

    /**
     * 获取当前月第n天：
     * @param dt
     * @return
     */
    public static Date getMonth_n_Day(Date dt,int n) {
        //获取当前月第一天：
        Calendar ca = Calendar.getInstance();
        ca.setTime(dt);
        // ca.add(Calendar.MONTH, 0); 此方法可以获取前n月或后n月
        ca.set(Calendar.DAY_OF_MONTH,n);//设置为1号,当前日期既为本月第一天
        ca.set(Calendar.HOUR, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 日期差值
     * @return
     */
    public static void getDiffer() {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        System.out.println("now:"+now);
        LocalDate startDate = LocalDate.parse("2021-05-26",formatter1);

        System.out.println("相差天数:" + startDate.until(now, ChronoUnit.DAYS));
        System.out.println("相差月数:" + startDate.until(now, ChronoUnit.MONTHS));
        System.out.println("相差年数:" + startDate.until(now, ChronoUnit.YEARS));
    }

    /**
     　　* @description: 24 * (differ / dayM) 这里拿到被舍弃的整数，整数是几，就代表相隔几天，一天24小时，那就整数乘以24即可。
     　　* @param 两个日期相差几个小时
     　　* @return
     　　* @throws
     　　* @author lgn
     　　* @date 2022/9/20 10:46
     　　*/
    public static int getDifferHour(Date startDate, Date endDate) {
        long between = startDate.getTime() - endDate.getTime();
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒");
        return Integer.parseInt(String.valueOf(hour));
    }

    /**
    　　* @description: 小时转换为xx天xx小时
    　　* @param
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/9/20 11:01 
    　　*/
    public static String getHourToDays(int total_hour) {
        int all=total_hour;
        int day=all/24;
        int hour=all%24;
        System.out.println(day+"天"+hour+"小时");
        return day+"天"+hour+"小时";
    }

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 获取startDate日期后month月的日期
     * @param startDate 开始日期
     * @param month  几个月后
     * @return
     */
    public static Date getMonthDate(Date startDate,int month){
        LocalDateTime localDateTime = startDate.toInstant()
                .atZone(ZoneId.systemDefault() )
                .toLocalDateTime().plusMonths(month);
        Date date = Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());
        return date;
    }


    public static void main(String[] args) throws ParseException {

        System.out.println("多少天后："+getDateAfter(new Date(),7));

        System.out.println("下个月的今天："+getMonthDate(new Date(),1));

        // String 转换为 LocalDateTime
        String dateStr = "2022-01-21";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        date = formatter.parse(dateStr);

        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();


    }
}
