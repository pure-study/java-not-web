/**
 * @(#)DoorClosing.java - Will's practices.
 */
package net.will.dpij.operation.state;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public class DoorClosing extends DoorState {
	/**
	 * @see net.will.dpij.operation.state.DoorState#complete()
	 */
	@Override
	public void complete(Door door) {
		door.setState(DoorConstants.CLOSED);
	}

	/**
	 * @see net.will.dpij.operation.state.DoorState#click(net.will.dpij.operation.state.Door)
	 */
	@Override
	public void click(Door door) {
		door.setState(DoorConstants.OPENING);
	}

}
