/**
 * @(#)DoorOpening.java - Will's practices.
 */
package net.will.dpij.operation.state;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public class DoorOpening extends DoorState {
	/**
	 * @see net.will.dpij.operation.state.DoorState#click()
	 */
	@Override
	public void click(Door door) {
		door.setState(DoorConstants.CLOSING);
	}

	/**
	 * @see net.will.dpij.operation.state.DoorState#complete(net.will.dpij.operation.state.Door)
	 */
	@Override
	public void complete(Door door) {
		door.setState(DoorConstants.OPEN);
	}

}
