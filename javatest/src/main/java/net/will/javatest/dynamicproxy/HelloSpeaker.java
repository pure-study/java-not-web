/**
 * @(#)HelloSpeaker.java - Will's practices.
 */
package net.will.javatest.dynamicproxy;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2009-2-24
 *
 */
public class HelloSpeaker implements IHello {

	/**
	 * @see com.will.dynamicproxy.IHello#hello(java.lang.String)
	 */
	public void hello(String name) {
		System.out.println("Hello, " + name);
	}

}
