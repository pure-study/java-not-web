/**
 * @(#)XMLConfigurationTest.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.commonsconf;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * Test for commons-configuration.
 *
 * @author Will
 * @version v1.0, 2009-12-21
 *
 */
@SuppressWarnings("unused")
public class XMLConfigurationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		test();
		testMore();  // failed: Caused by: java.net.UnknownHostException: castor.exolab.org
	}
	
	/**
	 * Test getPublicID() and getSystemID() in XMLConfiguration.
	 */
	public static void testMore() {
		try {
			String path = "net/will/opensourcestudy/castor/withmapping/mapping.xml";
//			URL url = Thread.currentThread().getContextClassLoader().getResource(path);
//			XMLConfiguration config = new XMLConfiguration(url);
			XMLConfiguration config = new XMLConfiguration(path);
			System.out.println( config.getPublicID() );
			System.out.println( config.getSystemID() );
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main test.
	 */
	public static void test() {
		try {
			XMLConfiguration config;
			
//			System.out.println( System.getProperty("user.dir") );
//			/* File(String pathname) */
//			File configFile = new File("src/main/java/net/will/opensourcestudy/commonsconf/conf_test.xml");
//			/* XMLConfiguration(File file) */
//			config = new XMLConfiguration(configFile);
			
//			URL url = Thread
//						.currentThread()
//						.getContextClassLoader()
//						.getResource("net/will/opensourcestudy/commonsconf/conf_test.xml");
//			/* XMLConfiguration(URL url) */
//			config = new XMLConfiguration(url);
			
			/* XMLConfiguration(String fileName) */
			config = new XMLConfiguration("net/will/opensourcestudy/commonsconf/conf_test.xml");
			
			@SuppressWarnings("rawtypes")
			Iterator keys = config.getKeys();
			System.out.println(keys);
			while (keys.hasNext()) {
				String key = (String) keys.next();
				System.out.println( key );
				
				String[] values = config.getStringArray(key);
				if (null == values || values.length <= 0) {
					System.out.println("NO VALUES");
					continue;
				}
				for (int i = 0; i < values.length; i++) {
					System.out.println( values[i] );
				}
			}
		} catch (ConfigurationException e) {
			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
		}
	}

}
