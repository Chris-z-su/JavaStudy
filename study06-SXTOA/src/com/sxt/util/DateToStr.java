package com.sxt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具类
 * 
 * @author Administrator
 *
 */
public class DateToStr {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdft = new SimpleDateFormat("hh:mm:ss");
	/**
	 * 将String类型转换为Date类型
	 * @param str
	 * @return
	 */
	public static Date str2Date(String str){
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将Date日期类型转换为String类型
	 * @param date
	 * @return
	 */
	public static String date2Str(Date date){
		return sdf.format(date);
	}
	
	/**
	 * 将Date时间类型转换为String类型
	 * @param date
	 * @return
	 */
	public static String dateTime2Str(Date date){
		return sdft.format(date);
	}
	
	/**
	 * 将java.sql.Date转换为java.util.Date
	 * @param sdate
	 * @return
	 */
	public static Date sql2util(java.sql.Date sdate){
		return new Date(sdate.getTime());
	}
	
	/**
	 * 将java.util.Date转换为java.sql.Date
	 * @param udate
	 * @return
	 */
	public static java.sql.Date util2sql(Date udate){
		return new java.sql.Date(udate.getTime());
	}
}
