/**
 * @(#)StringTest.java - Will's practices of Project javatest.
 */
package net.will.javatest.java.lang;

/**
 * 
 *
 * @author Will
 * @version 2012-6-6
 */
public class StringPoolTest {
	public static final String A = "ab";
	public static final String B = "cd";
	public static final String C;
	public static final String D;
	
	static {
		C = "ab";
		D = "cd";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Good";
	    System.out.print( "Good"+"bye"=="Go"+"odbye" );
	    System.out.print( (s+"bye").intern()=="Go"+"odbye" );
	    System.out.print( s+"bye"=="Go"+"odbye" );
	    
	    System.out.println();
	    println("===============");
	    part01();
	    println("===============");
	    part02();
	    println("===============");
	    part03();
	    println("===============");
	    part04();
	}
	
	protected static void part01() {
		String a = "ab"; // create an Object, and add it into the String Pool
		String b = "cd"; // create an Object, and add it into the String Pool
		String c = "abcd";  // create an Object, and add it into the String Pool
		
		String d = "ab" + "cd";
		if ( d == c ) {
			println("d == c: true");
		} else {
			println("d == c: false");
		}
		
		String e = a + "cd";
		if ( e == c ) {
			println("e == c: true");
		} else {
			println("e == c: false");
		}
		
		String f = a + b;
		if ( f == c ) {
			println("f == c: true");
		} else {
			println("f == c: false");
		}
	}
	
	protected static void part02() {
		String s1 = A + B;
		String t = "abcd";
		if ( s1 == t ) {
			println("s == t: true");
		} else {
			println("s == t: false");
		}
	}
	
	protected static void part03() {
		String s2 = C + D;
		String t = "abcd";
		if ( s2 == t ) {
			println("s == t: true");
		} else {
			println("s == t: false");
		}
	}
	
	protected static void part04() {
		String a = new String(new char[]{'e', 'f', 'g', 'h'});
		String b = a.intern();
		if ( a == b ) {
			println("a == b: true");
		} else {
			println("a == b: false");
		}
	}
	
	private static void println(String str) {
		System.out.println(str);
	}

}
