package net.will.javatest.basicconcept.jdk8;

public class ConvertFuncImplViaMethodRef {
    public Integer convertWithIntegerValueOf(String s) {
        IConvertFunc<String, Integer> t = Integer::valueOf;
        return t.convert(s);
    }
}
