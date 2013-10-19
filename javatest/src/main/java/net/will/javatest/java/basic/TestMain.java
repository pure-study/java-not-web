package net.will.javatest.java.basic;


public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1;
		int sum = i++ + ++i + i;
		
		System.out.println("sum= " + sum + " || i= " + i);
		// sum=7   i=3
	}

}
