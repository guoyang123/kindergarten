package cn.kinder.util;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * 时间处理
 * 
 * */
public class TimeUtils {

	
	/**
	 * 
	 * 根据时间戳获取当天的开始时间
	 * @param time 时间戳
	 * */
	public static long getStartTime(long time){
		Calendar todayStart = Calendar.getInstance();  
//todayStart.setTimeZone(setTimeZone(8));		
		todayStart.setTimeInMillis(time);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0); 
        
      
        return todayStart.getTime().getTime();
        
	}
	
	/**
	 * 
	 * 2014-7-7 10:35
	 * 
	 * */
	
	public static String getTopicDetailTime(String str){
		try{
			long time=Long.parseLong(str);
			time=time*1000;
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return format.format(new Date(time));
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	/**
	 * 
	 * 7-7 
	 * 
	 * */
	
	public static String getArticleTime(String str){
		try{
			long time=Long.parseLong(str);
			time=time*1000;
			SimpleDateFormat format=new SimpleDateFormat("MM-dd");
			return format.format(new Date(time));
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
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
	/**
	 * 2015-02
	 * */
	public static String getCheckTime(Date date){
		try{
			
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			return format.format(date);
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	/**
	 * 2015-02-10
	 * */
	public static String getTeacherCheckTime(Date date){
		try{
			
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			return format.format(date);
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
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
	
	/**获取时长*/
	public static String getTime(long time)
	{
		int second=(int)time/1000;
		StringBuffer sb=new StringBuffer();
		//分钟
		int minute=second/60;
		if(minute<10)
		{
			sb.append("0").append(minute);
		}else
		{
			sb.append(minute);
		}
		sb.append(":");
		//计算秒数
		int leftSec=second%60;
		if(leftSec<10)
		{
			sb.append("0").append(leftSec);
		}else
		{
			sb.append(leftSec);
		}
	
		
		return sb.toString();
	}
	/**多少天以后*/
	public static String getAfterday(String endtimestr)
	{
		
		
		long day=60*60*24*1000;
        //结束时间
       long endtime=Long.parseLong(endtimestr)*1000;
      
       //开始时间
       long starttime=System.currentTimeMillis();
      
       
       
       //step1:获取开始那天的结束时间戳
       long start_end=getEndTime(starttime);
        //step2:获取结束那天的开始时间戳
       long end_start=getStartTime(endtime);
       long total=1+(end_start-(start_end+1))/day;
       return String.valueOf(total)+"天后";
	}
	
}
