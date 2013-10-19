/**
 * 
 */
package net.will.javatest.java.collectiontest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Will
 * @version 2010-11-4
 *
 */
public class CollectionTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("d");
		a.add("c");
		a.add("a");
		a.add("b");
		Set<String> b = new TreeSet<String>(a);
		Iterator it = b.iterator();
		for(;it.hasNext();){
			System.out.print(it.next());
		}

	}

}
