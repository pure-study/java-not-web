package net.will.javatest.basicconcept.jdk8;

import java.util.Collection;
import java.util.function.Supplier;

public class ConstructorMethodRef {
    /**
     * Copies elements from one collection to another.
     * 
     * @param sourceCollection
     * @param collectionFactory
     * @return
     */
    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
            SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
        
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }
}
