package net.will.javatest.basicconcept.jdk8;

@FunctionalInterface
public interface IConvertFunc<T, R> {
    R convert(T t);
}
