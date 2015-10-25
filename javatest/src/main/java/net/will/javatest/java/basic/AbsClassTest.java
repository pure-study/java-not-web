package net.will.javatest.java.basic;

/**
 * Test for constructor of abstract classes.
 *
 * @author Will
 * @version 2015-10-26
 */
public abstract class AbsClassTest {
    public AbsClassTest() {}  // we can define constructor for abstract class

    public static void main(String[] args) {
//        AbsClassTest obj = new AbsClassTest();  // but cannot instantiate it
        AbsClassTest obj = new ExtendedClass();
        System.out.println(obj.hashCode());
    }

}

class ExtendedClass extends AbsClassTest {
    public ExtendedClass() {
        super();
    }
}