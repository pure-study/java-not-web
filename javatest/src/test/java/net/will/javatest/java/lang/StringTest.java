/**
 * 
 */
package net.will.javatest.java.lang;

import net.will.javatest.common.JavatestCommonVariables;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Will
 * @version 2008-11-18
 *
 */
public class StringTest {
	private static Logger logger = Logger
			.getLogger(JavatestCommonVariables.TEST_LOG_COMMON_PREFIX
					+ StringTest.class.getName());

	/**
	 * Test method for {@link java.lang.String#format(java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testFormatStringObjectArray() {
		String test = String.format("%s", "What's this?");
		logger.info(test);
	}

}
