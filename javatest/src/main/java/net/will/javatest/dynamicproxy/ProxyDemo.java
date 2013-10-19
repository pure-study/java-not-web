/**
 * @(#)ProxyDemo.java - Will's practices.
 */
package net.will.javatest.dynamicproxy;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2009-2-24
 *
 */
public class ProxyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogHandler logHandler = new LogHandler();
		
		IHello helloProxy = (IHello) logHandler.bind(new HelloSpeaker());
		helloProxy.hello("Will");
	}

}
