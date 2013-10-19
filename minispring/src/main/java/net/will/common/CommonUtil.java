/**
 * 
 */
package net.will.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author Will
 * @version 2013-8-10
 */
public final class CommonUtil {
	public static boolean isEmptyString(String str) {
		return ( (null == str) || "".equals(str.trim()) );
	}
	
	public static void close(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException ex) {
				// NOP
			}
		}
	}
}
