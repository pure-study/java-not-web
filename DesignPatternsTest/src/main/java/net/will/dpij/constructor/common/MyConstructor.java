/**
 * @(#)MyConstructor.java - Will's practices.
 */
package net.will.dpij.constructor.common;

/**
 * @author Will
 * @version v1.0, 2008-11-22
 */
public abstract class MyConstructor {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyConstructor() {
		this("");
	}
	
	public MyConstructor(String name) {
		this.name = name;
	}
}
