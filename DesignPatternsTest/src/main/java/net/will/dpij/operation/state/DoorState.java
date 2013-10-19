/**
 * @(#)DoorState.java - Will's practices.
 */
package net.will.dpij.operation.state;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public abstract class DoorState {
	public DoorState() {
	}
	
	public abstract void click(Door door);
	
	public void complete(Door door) {}
	
	public String getStatusStr() {
		String s = getClass().getName();
		return s.substring( s.lastIndexOf('.') + 5 );
	}
	
	public void timeout(Door door) {}
}
