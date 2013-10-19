/**
 * 
 */
package net.will.minispring;

/**
 * 
 * @author Will
 * @version 2013-8-13
 */
public class NotReadablePropertyException extends RuntimeException {
	private static final long serialVersionUID = -1622390206290725584L;
	
	public NotReadablePropertyException(Class<?> clazz, String propName) {
		super("Bean property '" + propName + "' in Class '" + clazz +
				"' is not readable or has an invalid getter method.");
	}
}
