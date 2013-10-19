/**
 * @(#)LogHandler.java - Will's practices.
 */
package net.will.javatest.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2009-2-24
 *
 */
public class LogHandler implements InvocationHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Object delegate;
	
	public Object bind(Object delegate) {
		this.delegate = delegate;

		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
				delegate.getClass().getInterfaces(), this);
	}

	/**
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		
		try {
			log("method starts... " + method);
			
			result = method.invoke(delegate, args);
//			result = method.invoke(proxy, args);    // it's wrong!!
			
			log("method ends... " + method);
		} catch (Exception e) {
			log(e.toString());
		}
		
		return result;
	}

	private void log(String message) {
		logger.log(Level.INFO ,message);
	}
}
