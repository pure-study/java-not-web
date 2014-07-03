/**
 * 
 */
package net.will.javatest.java.lang;

/**
 * @author Will
 *
 */
public class StringBasicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testLength();
	}
	
	public static void testLength() {
		String a1 = "123";
		String a2 = "中文";
		System.out.println(a1.length());
		System.out.println(a1.getBytes().length);
		System.out.println(a2.length());
		System.out.println(a2.getBytes().length);
	}

}
