package net.will.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Common util methods.
 * 
 * @author Will
 * @version 2011-9-7
 */
public final class StaticMethod {
	
	public static String getCurrentTimeString() {
		java.util.Date date = Calendar.getInstance().getTime();
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static String formatTimestamp(Timestamp timestamp) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "";
		try {
			result = dateFormat.format(new Date(timestamp.getTime()));
		} catch (Exception e) {
			result = "";
		}
		
		return result;
	}
	
	public static String formatDate(java.util.Date date, String format) {
		String result = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			result = dateFormat.format(date);
		} catch (Exception e) {
			result = "";
		}
		
		return result;
	}
	
	public static String getCurrentYear() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		return "" + year;
	}
	
	public static String getCurrentMonth() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;
		if (month < 10) 
			return "0" + month;
		
		return "" + month;
	}
	
	public static String trimEndChar(String str, String ch) {
		int len = str.length();
		if(str.endsWith(ch))
			str = str.substring(0,(len - 1));
		
		return str;
	}
	
	public static String null2String(String s) {
		return s == null ? "" : s;
	}
	
	public static String nullObject2String(Object obj) {
		String ret = "";
		
		try {
			ret = obj.toString();
		} catch (Exception e) {
			ret = "";
		}
		
		return ret;
	}
	
	public static int null2Int(String s) {
		int value = 0;
		try {
			value = Integer.parseInt(s);
		} catch (Exception e) {
			value = 0;
		}
		return value;
	}
	
	public static int null2Int(String s, int defaultValue) {
		int value = defaultValue;
		try {
			value = Integer.parseInt(s);
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	
	public static int nullObject2Int(Object obj) {
		int value = 0;
		try {
			value = Integer.parseInt(obj.toString());
		} catch (Exception e) {
			value = 0;
		}
		return value;
	}
	
	private StaticMethod() {}
	
	public static void main(String args[]) {
		//
	}
}
