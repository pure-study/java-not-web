/**
 * 
 */
package net.will.javatest.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author will
 * @version 2012-07-09
 */
public class QuantifiersTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test02();
//		test01();
	}
	
	public static void test02() {
		String dest = "split me    with reg";
		String reg = "\\s+";
		String[] res = dest.split(reg);
		for (String r : res) {
			System.out.println(r);
		}
	}
	
	public static void test01() {
		String dest = "abc=cde=fgh";
		String regGreedy = "(\\S*)=(\\S*)";
		String regReluctant = "(\\S*?)=(\\S*?)";
		String regPossessive = "(\\S*+)=(\\S*+)";
		String regPossessive2 = "(\\S{3}+)=(\\S{3}+)";
		System.out.println(dest.matches(regGreedy));
		System.out.println(dest.matches(regReluctant));
		System.out.println(dest.matches(regPossessive));
		System.out.println(dest.matches(regPossessive2));
		System.out.println("====================");
		
		Matcher mchGreedy = Pattern.compile(regGreedy).matcher(dest);
		Matcher mchReluctant = Pattern.compile(regReluctant).matcher(dest);
		Matcher mchPossessive = Pattern.compile(regPossessive).matcher(dest);
		Matcher mchPossessive2 = Pattern.compile(regPossessive2).matcher(dest);
		while ( mchGreedy.find() ) {
			System.out.println(mchGreedy.group(0));
			System.out.println(mchGreedy.group(1));
			System.out.println(mchGreedy.group(2));
		}
		System.out.println("====================");
		while ( mchReluctant.find() ) {
			System.out.println(mchReluctant.group(0));
			System.out.println(mchReluctant.group(1));
			System.out.println(mchReluctant.group(2));
		}
		System.out.println("====================");
		while ( mchPossessive.find() ) {
			System.out.println(mchPossessive.group(0));
			System.out.println(mchPossessive.group(1));
			System.out.println(mchPossessive.group(2));
		}
		System.out.println("====================");
		while ( mchPossessive2.find() ) {
			System.out.println(mchPossessive2.group(0));
			System.out.println(mchPossessive2.group(1));
			System.out.println(mchPossessive2.group(2));
		}
		System.out.println("====================");
	}

}
