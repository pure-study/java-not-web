/**
 * @(#)Door.java - Will's practices.
 */
package net.will.dpij.operation.state;

import java.util.Observable;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public class Door extends Observable implements DoorConstants {
	private DoorState state = CLOSED;
	
	public void click() {
		this.state.click(this);
	}
	
	public void complete() {
		this.state.complete(this);
	}
	
	protected void setState(DoorState state) {
		this.state = state;
		setChanged();
		notifyObservers();
	}
	
	public String getStatusStr() {
		return this.state.getStatusStr();
	}
	
	public void timeout() {
		this.state.timeout(this);
	}
}
