/**  
 * @Title: TimeUtils.java
 * @Package org.csun.nc.utils
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2017年10月23日
 */
package org.study.asdl.utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * ClassName: TimeUtils 
 * @Description: 时间格式转换改工具类
 * @author chisj chisj@foxmail.com
 * @date 2017年10月23日
 */
public class TimeUtils {

	//时间
	static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	//日期格式
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
	/**
	 * 转换Date类型为时间字符串 按"yyyy-MM-dd HH:mm:ss"格式
	 * @param date
	 * @return
	 */
	public static String DataToString(Date date){
		return  dateFormat.format(date);
	}
		
	/**
	 * 获取当前时间按"yyyy-MM-dd-hh"格式
	 * @return
	 */
	public static String getNowTimeR(){
		return  new SimpleDateFormat("yyyy-MM-dd-hh").format(new Date());
	}
	
	/**
	 * 获取当前时间的字符串 "yyyy-MM-dd"格式
	 * @return
	 */
	public static String getNowTime(){
		return  timeFormat.format(new Date());
	}
	
	/**
	 * 获取当前时间的Timestamp
	 * @return
	 */
	public static Timestamp getNowTimestamp(){
		return  Timestamp.valueOf(timeFormat.format(new Date()));
	}
	
	/**
	 * 获取今天的日期字符串  "yyyy-MM-dd"格式
	 * @return
	 */
	public static String getToday(){
		return dateFormat.format(new Date());
	}
	
	/**
	 * 获取昨天的日期字符串  "yyyy-MM-dd"格式
	 * @return
	 */
	public static String getYestoday(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
		return dateFormat.format(c.getTime());
	}
	
	/** 
	 * 将timestamp转换成date 
	 * @author hellostoy 
	 * @param tt 
	 * @return 
	 */  
	public static Date timestampToDate(Timestamp tt){  
	    return new Date(tt.getTime());  
	}
	
	/**
	 * timestamp转Format String
	 */
	public static String timestampToString(Timestamp tt){  
	    return timeFormat.format(new Date(tt.getTime()));  
	}
	
	/**
	 * 转换日期格式"yyyy-MM-dd"字符串为Date
	 * @throws ParseException 
	 */
	public static Date dateStringToDate(String date) throws ParseException{  
	    return dateFormat.parse(date);  
	}
	
	/**
	 * 转行日期时间“yyyy-MM-dd hh:mm:ss” 为Date
	 */
	public static Date dateTimeStringToDate(String dateTime) throws ParseException{  
	    return timeFormat.parse(dateTime);  
	}
	
	public static String getPaymentNo() {
		
		Random random = new Random();
		DecimalFormat df = new DecimalFormat("00");
		String paymentNo = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date()) + df.format(random.nextInt(100));
		
		return paymentNo;
	}
	
}
