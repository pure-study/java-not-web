/**
 * @(#)DoorStateTest.java - Will's practices.
 */
package net.will.dpijtest.operation.state;

import static org.junit.Assert.*;

import org.junit.Test;

import net.will.dpij.operation.state.DoorClosing;
import net.will.dpij.operation.state.DoorState;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public class DoorStateTest {

	/**
	 * Test method for {@link net.will.dpij.operation.state.DoorState#getStatusStr()}.
	 */
	@Test
	public void testGetStatusStr() {
		DoorState state = new DoorClosing();
		System.out.println( state.getStatusStr() );
		assertEquals("Closing", state.getStatusStr());
	}

}
