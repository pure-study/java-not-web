/**
 * @(#)DoorOpen.java - Will's practices.
 */
package net.will.dpij.operation.state;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public class DoorOpen extends DoorState {
	/**
	 * @see net.will.dpij.operation.state.DoorState#click()
	 */
	@Override
	public void click(Door door) {
		door.setState(DoorConstants.STAYOPEN);
	}

	/**
	 * @see net.will.dpij.operation.state.DoorState#timeout()
	 */
	@Override
	public void timeout(Door door) {
		door.setState(DoorConstants.CLOSING);
	}

}
