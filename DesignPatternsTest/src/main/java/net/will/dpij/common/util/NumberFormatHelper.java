/**
 * 
 */
package net.will.dpij.common.util;

import java.text.DecimalFormat;

/**
 * @author Will
 *
 */
public class NumberFormatHelper {
	public static String formatDouble(double d) {
		DecimalFormat format = new DecimalFormat("#.0");
		return format.format(d);
	}
}
