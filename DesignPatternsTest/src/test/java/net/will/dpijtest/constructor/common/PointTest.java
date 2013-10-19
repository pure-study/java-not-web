/**
 * @(#)PointTest.java - Will's practices.
 */
package net.will.dpijtest.constructor.common;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

/**
 * @author Will
 * @version v1.0, 2008-11-22
 */
public class PointTest {

	/**
	 * Test method for {@link java.awt.Point#Point(int, int)}.
	 */
	@Test
	public void testPointIntInt() {
		Constructor<?>[] c = Point.class.getConstructors();
		Constructor<?> cons = null;
		for (int i = 0; i < c.length; i++) {
			if (2 == c[i].getParameterTypes().length) {
				cons = c[i];
			}
		}
		
		try {
			Object obj = cons.newInstance(new Object[] { new Integer(3),
					new Integer(4) });
			System.out.println(obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail(e.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
			fail(e.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			fail(e.toString());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
