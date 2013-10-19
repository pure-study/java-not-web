/**
 * 
 */
package net.will.javatest.java.maptest;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 更好的排序方式，可以参见think in java 11章中的练习。
 * 
 * @author Will
 * @version 2011-4-6
 *
 */
public class HashtableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 测试Hashtable的key，在取出来时，是否有什么顺序
		// 结果：没有特定顺序
		Hashtable<String, String> hst = new Hashtable<String, String>();
		hst.put("key01", "value01");
		hst.put("key05", "value02");
		hst.put("key21", "value03");
		hst.put("key51", "value04");
		hst.put("key31", "value05");
		
		Iterator<String> itr = hst.keySet().iterator();
		while ( itr.hasNext() ) {
			String key = itr.next();
			String value = hst.get(key);
			System.out.println(key + ": " + value);
		}
		
		// 通过一个List对key进行排序
		LinkedList<String> keys = new LinkedList<String>();
		keys.addLast("key01");
		keys.addLast("key05");
		keys.addLast("key21");
		keys.addLast("key31");
		keys.addLast("key51");
		
		while (!keys.isEmpty()) {
			String key = keys.poll();
			String value = hst.get(key);
			System.out.println(key + ": " + value);
		}
	}

}
