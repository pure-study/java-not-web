/**
 * @(#)JavaUtilLoggerTest.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.commonslogging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * By default, the java.util.loggin.LogManager reads its initial configuration from a
 * properties file "lib/logging.properties" in the JRE directory(see 
 * LogManager.readConfiguration()).
 * 
 * @author Will
 * @version 2011-12-8
 *
 */
public class JavaUtilLoggerTest {
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public Logger getLogger() {
		return this.logger;
	}

	public static void main(String[] args) {
		//System.out.println("java.home: " + System.getProperty("java.home"));
		System.setProperty("java.util.logging.config.file", "target\\classes\\logging.properties");
		JavaUtilLoggerTest test = new JavaUtilLoggerTest();
		testLoggerPriority(test.getLogger());
		
		OtherLevelTest otherLevelTest = new OtherLevelTest();
		testLoggerPriority(otherLevelTest.getLogger());
	}
	
	public static void testLoggerPriority(Logger logger) {
		if ( logger.isLoggable(Level.SEVERE) ) {
			logger.log(Level.SEVERE, logger.getName() + " ==> This is a SEVERE log.");
		}
		if ( logger.isLoggable(Level.WARNING) ) {
			logger.log(Level.WARNING, logger.getName() + " ==> This is a WARNING log.");
		}
		if ( logger.isLoggable(Level.INFO) ) {
			logger.log(Level.INFO, logger.getName() + " ==> This is a INFO log.");
		}
		if ( logger.isLoggable(Level.CONFIG) ) {
			logger.log(Level.CONFIG, logger.getName() + " ==> This is a CONFIG log.");
		}
		if ( logger.isLoggable(Level.FINE) ) {
			logger.log(Level.FINE, logger.getName() + " ==> This is a FINE log.");
		}
		if ( logger.isLoggable(Level.FINER) ) {
			logger.log(Level.FINER, logger.getName() + " ==> This is a FINER log.");
		}
		if ( logger.isLoggable(Level.FINEST) ) {
			logger.log(Level.FINEST, logger.getName() + " ==> This is a FINEST log.");
		}
	}

}

class OtherLevelTest {
	private final Logger logger = Logger.getLogger("OtherLevelTest");
	
	public Logger getLogger() {
		return this.logger;
	}
}
