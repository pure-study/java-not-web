/**
 * @(#)Location.java - Will's practices.
 */
package net.will.dpij.constructor.prototype;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2008-11-30
 *
 */
public class Location {
	private int bay;
	private double x;
	private double y;
	
	public void setBay(int bay) {
		this.bay = bay;
	}
	
	public int getBay() {
		return this.bay;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setCoordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	protected Object clone() {
		Location newobj = new Location();
		newobj.setBay(this.bay);
		newobj.setCoordinates(this.x, this.y);
		
		return newobj;
	}
	
	public Location copy() {
		return (Location) this.clone();
	}
}
