package net.will.javatest.basicconcept.jdk8;

public class ConvertFuncImpl implements IConvertFunc<String, Integer> {
    @Override
    public Integer convert(String t) {
        return Integer.valueOf(t);
    }
    
}
