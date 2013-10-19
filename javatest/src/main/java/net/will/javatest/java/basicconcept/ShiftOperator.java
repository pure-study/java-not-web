/**
 * @(#)ShiftOperator.java - Will's practices of Project IndependentTest.
 */
package net.will.javatest.java.basicconcept;

/**
 * @author Will
 * @version 2011-9-23
 *
 */
public class ShiftOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 3;
		print(i);
		print(i << 3);
		
		int j = 30;
		print(j);
		print(j >> 3);
		print(j >>> 3);
		
		int k = -64;
		print(k);
		print(k >> 3);
		print(k >>> 3);
		
		int h = (byte)(1 << 7);
		System.out.println((byte)(1 << 7));
		print(h);
	}
	
	/**
	 * @param i
	 */
	private static void print(int i) {
		System.out.println(Integer.toBinaryString(i) + " = " + i);
	}

}
