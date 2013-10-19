/**
 * @(#)SomeBean.java - Will's practices of Project springtest.
 */
package net.will.javatest.spring.basicconfig;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2009-10-3
 *
 */
public class SomeBean {
	private String bname;

	/**
	 * @return the bname
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * @param bname the bname to set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public String toString() {
		return this.getClass().getName() + "[" + this.bname + "]";
	}
	
}
