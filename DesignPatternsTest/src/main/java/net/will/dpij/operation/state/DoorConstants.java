/**
 * @(#)DoorConstants.java - Will's practices.
 */
package net.will.dpij.operation.state;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-12-3
 *
 */
public interface DoorConstants {
	public final DoorState CLOSED = new DoorClosed();
	public final DoorState OPENING = new DoorOpening();
	public final DoorState OPEN = new DoorOpen();
	public final DoorState CLOSING = new DoorClosing();
	public final DoorState STAYOPEN = new DoorStayOpen();
}
