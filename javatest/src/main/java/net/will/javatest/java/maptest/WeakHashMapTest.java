/**
 * 
 */
package net.will.javatest.java.maptest;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Will
 * @version 2011-9-29
 */
public class WeakHashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = new String("a");
		String b = new String("b");
		String c = "c";
		Map<String, String> weakmap = new WeakHashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(a, "aaa");
		map.put(b, "bbb");
		map.put(c, "ccc");
		weakmap.put(a, "aaa");
		weakmap.put(b, "bbb");
		weakmap.put(c, "ccc");
		
		System.out.println(map);
		System.out.println(weakmap);
		
		map.remove(a);
		map.remove(c);
		a = null;
		b = null;
		c = null;
		System.gc();
		
		System.out.println(map);
		System.out.println(weakmap);
	}

}
