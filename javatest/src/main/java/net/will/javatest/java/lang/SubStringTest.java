/**
 * @(#)SubStringTest.java - Will's practices of Project IndependentTest.
 */
package net.will.javatest.java.lang;

/**
 * @author Will
 * @version 2011-9-14
 *
 */
public class SubStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abc.txt";
		String s2 = "abc.";
		String s3 = "abc";
		
		System.out.println(s1.substring(s1.lastIndexOf('.') + 1));
		System.out.println(s2.substring(s2.lastIndexOf('.') + 1));
		System.out.println("1234".substring(4));
		System.out.println(s3.substring(s3.lastIndexOf('.')));
	}

}
