package net.will.javatest.basicconcept.jdk8;

import java.util.function.Supplier;

public class SupplierAssistant implements Supplier<String> {
    @Override
    public String get() {
        return "assistance";
    }
}
