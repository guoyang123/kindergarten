package com.squareup.timessquare.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 时间处理
 * 
 * */
public class TimeUtils {

	
	
	

	/**
	 * 
	 * 2014-07-06
	 * 
	 * */
	public static String getActivityDetailTime(String timestr){
		try{
			long time=Long.parseLong(timestr);
			time=time*1000;
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			return format.format(new Date(time));
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	/**判断是否为周六日*/
	public  static boolean isWeekEnd(Date date)
	{

		//Date date=new Date(time);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		int weekDay=c.get(Calendar.DAY_OF_WEEK);
		if(weekDay==Calendar.SATURDAY||weekDay==Calendar.SUNDAY)
		{
			return true;
		}
		
		return false;
	}
	
	/**返回节假日*/
	public static String getHoliDay(long time)
	{
			SimpleDateFormat format=new SimpleDateFormat("MM-dd");
			String str=format.format(new Date(time));
			if(str.equals("01-01"))
			{
				return "元旦";
			}else if(str.equals("04-05"))
			{
				return "清明节";
			}else if(str.equals("05-01"))
			{
				return "劳动节";
			}else if(str.equals("06-20"))
			{
				return "端午节";
			}else if(str.equals("09-03"))
			{
				return "胜利日";
			}else if(str.equals("10-01"))
			{
				return "国庆节";
			}
		return null;
	}
	/**
	 * 
	 * 9:00
	 * 
	 * 
	 * */
	public static String getActivityTopicTime(String timestr){
		try{
			long time=Long.parseLong(timestr);
			time=time*1000;
			SimpleDateFormat format=new SimpleDateFormat("HH:mm");
			return format.format(new Date(time));
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	/**
	 * 
	 * 2005年1月 -至今
	 * 0：至今
	 * 
	 * 
	 * */
	public static String getUserCenterPlug_WorkTime(String timestr){
		if(timestr!=null&&timestr.equals("0")){
			return "至今";
		}
		try{
			long time=Long.parseLong(timestr);
			time=time*1000;
			SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月");
			return format.format(new Date(time));
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	
	/**
	 * 
	 * 
	 * 字符串转成时间戳
	 * 例如：2012-4-23转成时间戳
	 * 
	 * */
	public static String getTimestampFromStr(String user_time){
		
		String re_time = null;  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date d;  
		try {  
		  
		  
		d = sdf.parse(user_time);  
		long l = d.getTime();  
		String str = String.valueOf(l);  
		re_time = str.substring(0, 10);  
		  
		  
		} catch (Exception e) {  
		// TODO Auto-generated catch block  
		e.printStackTrace(); 
		return null;
		}  
		return re_time;  
	}
	
	/**
	 * 根据时间戳获取日期
	 * 
	 * */
	public static String getDay(long time){
		
		SimpleDateFormat format=new SimpleDateFormat("dd日");
//		format.setTimeZone(setTimeZone(8));
		return format.format(new Date(time));		
	}
	
	

	/**
	 * 
	 * 根据时间戳获取当天的开始时间
	 * @param time 时间戳
	 * */
	public static long getStartTime(long time){
		Calendar todayStart = Calendar.getInstance();  
//todayStart.setTimeZone(setTimeZone(8));		
		todayStart.setTimeInMillis(time);
        todayStart.set(Calendar.HOUR, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime().getTime();
        
	}
	/**
	 * 
	 * 根据时间戳获取当天的结束时间
	 * @param time 时间戳
	 * 
	 * */
	public static long getEndTime(long time){
		Calendar todayStart = Calendar.getInstance(); 
//todayStart.setTimeZone(setTimeZone(8));
		todayStart.setTimeInMillis(time);
        todayStart.set(Calendar.HOUR, 23);  
        todayStart.set(Calendar.MINUTE, 59);  
        todayStart.set(Calendar.SECOND, 59);  
        todayStart.set(Calendar.MILLISECOND, 999);  
        return todayStart.getTime().getTime();
        
	}
	
	/**
	 * 
	 * 设置东八区
	 * 
	 * */
//	public static TimeZone setTimeZone(int timeZoneOffset){
//		  TimeZone timeZone=null;
//		     String[] ids = TimeZone.getAvailableIDs(timeZoneOffset * 60 * 60 * 1000);
//Log.e("buzz1", "ids:"+ids.length);
//		     if (ids.length == 0) {
//		         // if no ids were returned, something is wrong. use default TimeZone
//		         timeZone = TimeZone.getDefault();
//		     } else {
//		         timeZone = new SimpleTimeZone(timeZoneOffset * 60 * 60 * 1000, ids[0]);
//		     }
//		     return timeZone;
//	}
//	
}
