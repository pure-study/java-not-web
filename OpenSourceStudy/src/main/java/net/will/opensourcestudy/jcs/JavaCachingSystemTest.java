/**
 * @(#)JavaCachingSystemTest.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.jcs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 * @author Will
 * @version 2011-12-7
 *
 */
public class JavaCachingSystemTest {
	private static final Log log = LogFactory.getLog(JavaCachingSystemTest.class);
	
	private static final String cacheRegionName = "testCache1";

	public static void main(String[] args) {
		testPut();
		testGet();
	}
	
	static void testPut() {
		try {
			JCS jcs = JCS.getInstance(cacheRegionName);
			jcs.put("key01", "value01");
			if (log.isInfoEnabled()) {
				log.info("put OK!");
			}
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}
	
	static void testGet() {
		try {
			JCS jcs = JCS.getInstance(cacheRegionName);
			Object value = jcs.get("key01");
			if (log.isInfoEnabled()) {
				log.info("get information: " + value );
			}
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

}
