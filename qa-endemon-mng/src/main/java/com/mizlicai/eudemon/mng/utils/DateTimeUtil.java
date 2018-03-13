//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mizlicai.eudemon.mng.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeUtil {
    public static final String TIME_END = " 23:59:59";
    public static final String TIME_START = " 00:00:00";

    public DateTimeUtil() {
    }

    
    /** 
	 * 根据日期获得所在周所有日期  
	 * @param mdate 
	 * @return 
	 */  
	@SuppressWarnings("deprecation")  
	public static List<Date> dateToWeek(Date mdate) {  
	    int b = mdate.getDay();  
	    Date fdate;  
	    List<Date> list = new ArrayList<Date>();  
	    Long fTime = mdate.getTime() - b * 24*3600000;  
	    for(int a = 1; a <= 7; a++) {  
	        fdate = new Date();  
	        fdate.setTime(fTime + (a * 24*3600000)); //一周从周日开始算，则使用此方式  
	        //fdate.setTime(fTime + ((a-1) * 24*3600000)); //一周从周一开始算，则使用此方式  
	        list.add(a-1, fdate);  
	    }  
	    return list;  
	}  
    
   /*
	* 
    * 获取最近12个月，用于图表统计
    */  
   public static String[] getRecent12Months(){  
         
       String[] recent12Months = new String[12];  
         
       Calendar cal = Calendar.getInstance();  
       cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //要先+1,才能把本月的算进去 
       for(int i=0; i<12; i++){  
           cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月  
           recent12Months[11-i] = cal.get(Calendar.YEAR)+ "-" + ((cal.get(Calendar.MONTH)+1)<10?"0":"")+(cal.get(Calendar.MONTH)+1);  
       }  
         
       return recent12Months;  
   }  

   public static String[] getRecent12MonthsOtherFormat(){  
       
       String[] recent12Months = new String[12];  
         
       Calendar cal = Calendar.getInstance();  
       cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //要先+1,才能把本月的算进去 
       for(int i=0; i<12; i++){  
           cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月  
           recent12Months[11-i] = cal.get(Calendar.YEAR)+ "." + ((cal.get(Calendar.MONTH)+1)<10?"0":"")+(cal.get(Calendar.MONTH)+1);  
       }  
         
       return recent12Months;  
   }  
	
    public static int getBetweenDay(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time1 - time2) / 86400000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int getBetweenDayIgnoreTime(Date early, Date late) {
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(early);
        Calendar cal_2 = Calendar.getInstance();
        cal_2.setTime(late);
        cal_1.set(11, 0);
        cal_1.set(12, 0);
        cal_1.set(13, 0);
        cal_2.set(11, 0);
        cal_2.set(12, 0);
        cal_2.set(13, 0);
        long time_1 = cal_1.getTimeInMillis() / 1000L;
        long time_2 = cal_2.getTimeInMillis() / 1000L;
        return (int)((time_2 - time_1) / 3600L / 24L);
    }

    public static int getBetweenSeconds(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time1 - time2) / 1000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    public static String getDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static String getDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date getDateAndMaxTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate = null;

        try {
            newDate = dateTimeFormat.parse(dateFormat.format(date) + " 23:59:59");
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return newDate;
    }

    public static String getDateByDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, day);
        Date createDate = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(createDate);
    }

    public static Date getDateDay(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(dateFormat.format(date));
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date getDateDay(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(date);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date getDateTime(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return dateFormat.parse(time);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date getDate(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(time);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date getDateWithFirstTime(Date date) {
        return getDateWithFirstTime(getDate(date));
    }

    public static Date getDateWithFirstTime(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return dateFormat.parse(date + " 00:00:00");
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date getDateWithLastTime(Date date) {
        return getDateWithLastTime(getDate(date));
    }

    public static Date getDateWithLastTime(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return dateFormat.parse(date + " 23:59:59");
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String getDayBeforeYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -2);
        Date createDate = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(createDate);
    }

    public static String getLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        Date createDate = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(createDate);
    }

    public static String getLastDay(String day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDateDay(day));
        calendar.add(5, -1);
        Date createDate = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(createDate);
    }

    public static String getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        Date createDate = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM")).format(createDate);
    }

    public static String getNextDay(String day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDateDay(day));
        calendar.add(5, 1);
        Date createDate = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(createDate);
    }

    public static String getFirstDateThisMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return format.format(c.getTime());
    }

    public static String getLastDateThisMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(ca.getTime());
    }

    
  
    public static void main(String[] args) {
    }
}
