/**
 * @(#)GetSimpleNameOfClassTest.java - Will's practices of Project IndependentTest.
 */
package net.will.javatest.java.lang;

/**
 * @author Will
 * @version 2011-9-14
 *
 */
public class GetSimpleNameOfClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GetSimpleNameOfClassTest g = new GetSimpleNameOfClassTest();
		System.out.println(g.getClass().getSimpleName());
		System.out.println(g.getClass().getName());
	}

}
