/**
 * 
 */
package net.will.javatest.java.basicconcept;

/**
 * Test for override of property variable.
 * 
 * @author Will
 * @version 2013-8-4
 */
public class SubClass extends ParentClass {
	public int i = 30;

	public static void main(String[] args) {
		ParentClass parentClass = new SubClass();
		SubClass subClass = new SubClass();
		System.out.println(parentClass.i);
		System.out.println(subClass.i);
	}

}

class ParentClass {
	public int i = 10;
}