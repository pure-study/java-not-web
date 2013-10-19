/**
 * @(#)People.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.castor;

import java.util.Arrays;


/**
 * @author Will
 * @version 2011-11-25
 *
 */
public class People {
	private Person[] person;

	public Person[] getPerson() {
		return person;
	}

	public void setPerson(Person[] person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("People[");
		if (person != null && person.length > 0) {
			sb.append(Arrays.toString(person));
		}
		sb.append("]");
		return  sb.toString();
	}
}
