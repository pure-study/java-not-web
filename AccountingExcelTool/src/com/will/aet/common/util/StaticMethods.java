/**
 * 
 */
package com.will.aet.common.util;

import java.math.BigDecimal;

/**
 * @author Will
 * @version 2010-07-07
 *
 */
public class StaticMethods {
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static String null2String(String s) {
		String str = "";
		try {
			str = (null==s) ? "" : s;
		} catch (Exception e) {
			str = "";
		}
		return str;
	}
	
	public static String nullObject2String(Object s) {
		String str = "";
		try {
			str = s.toString();
		} catch (Exception e) {
			str = "";
		}
		return str;
	}

	public static String nullObject2String(Object s, String defaultStr) {
		String str = defaultStr;
		try {
			str = s.toString();
		} catch (Exception e) {
			str = defaultStr;
		}
		return str;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static int null2int(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}
	
	public static int null2int(String s, int defaultInt) {
		int i = defaultInt;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			i = defaultInt;
		}
		return i;
	}

	public static int nullObject2int(Object s) {
		String str = "";
		int i = 0;
		try {
			str = s.toString();
			i = Integer.parseInt(str);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	public static int nullObject2int(Object s, int defaultInt) {
		String str = "";
		int i = defaultInt;
		try {
			str = s.toString();
			i = Integer.parseInt(str);
		} catch (Exception e) {
			i = defaultInt;
		}
		return i;
	}
	
	public static int nullDoubleString2int(String s) {
		int i = 0;
		try {
			i = new Double(s).intValue();
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}
	
	public static int nullDecimalString2int(String s) {
		int i = 0;
		try {
			i = new BigDecimal(s).intValue();
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static double null2double(String s) {
		double d = 0.0;
		try {
			d = Double.parseDouble(s);
		} catch (Exception e) {
			d = 0.0;
		}
		return d;
	}
	
	public static double nullObject2double(Object obj) {
		double d = 0.0;
		String str = "";
		try {
			str = obj.toString();
			d = Double.parseDouble(str);
		} catch (Exception e) {
			d = 0.0;
		}
		return d;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
}
