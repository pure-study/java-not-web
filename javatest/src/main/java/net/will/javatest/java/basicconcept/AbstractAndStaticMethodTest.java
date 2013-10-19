/**
 * 
 */
package net.will.javatest.java.basicconcept;

/**
 * abstract和static不能修饰同一个方法；
 * 
 * static方法是从属于类的，不参与继承。比如此测试程序中的obj.printTest();就会比较费解，运行结果到底是怎样的？
 * 
 * @author Will
 * @version 2010-11-16
 *
 */
public class AbstractAndStaticMethodTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		FatherClass obj = new ChildClass();
		obj.printTest();    // 打印FatherClass
	}

}

abstract class FatherClass {
	public static void printTest() {
		System.out.println("FatherClass");
	}
	
//	public abstract static void printTestAb();   // 错误方法
}

class ChildClass extends FatherClass {
	public static void printTest() {
		System.out.println("ChildClass");
	}
}
