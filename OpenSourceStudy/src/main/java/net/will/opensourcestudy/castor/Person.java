/**
 * @(#)Person.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.castor;

/**
 * @author Will
 * @version 2011-11-25
 *
 */
public class Person {
	private String first;
	private String last;
	private String otherProp;
	public Person(String first, String last, String otherProp) {
		this.first = first;
		this.last = last;
		this.otherProp = otherProp;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getOtherProp() {
		return otherProp;
	}
	public void setOtherProp(String otherProp) {
		this.otherProp = otherProp;
	}
	@Override
	public String toString() {
		return "Person[" + first + "," + last + "," + otherProp + "]";
	}
}
