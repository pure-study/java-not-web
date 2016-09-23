package net.will.opensourcestudy.powermock;

public class StaticMethodCaller {
    public void execute() {
        TestObjectWithStatic.firstStaticMethod("first string");
        TestObjectWithStatic.secondStaticMethod();
        TestObjectWithStatic.firstStaticMethod("another string");
    }
}
