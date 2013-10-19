/**
 * @(#)LocationTest.java - Will's practices.
 */
package net.will.dpijtest.constructor.prototype;

import static org.junit.Assert.*;

import org.junit.Test;

import net.will.dpij.constructor.prototype.Location;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-11-30
 *
 */
@SuppressWarnings("unused")
public class LocationTest {

	/**
	 * Test method for {@link net.will.dpij.constructor.prototype.Location#clone()}.
	 */
	@Test(expected = CloneNotSupportedException.class)
	public void testClone() {
		Location loc1 = new Location();
		loc1.setBay(1);
		loc1.setCoordinates(2.5, 3.6);
		
		Location loc2 = loc1.copy();
		
		System.out.println(loc2.getBay());
	}

}
