/**
 * 
 */
package net.will.minispring;

/**
 * 
 * @author Will
 * @version 2013-8-13
 */
public class NotWritablePropertyException extends RuntimeException {
	private static final long serialVersionUID = 338954787765433381L;

	public NotWritablePropertyException(Class<?> clazz, String propName) {
		super("Bean property '" + propName + "' in Class '" + clazz +
				"' is not writable or has an invalid setter method.");
	}
}
