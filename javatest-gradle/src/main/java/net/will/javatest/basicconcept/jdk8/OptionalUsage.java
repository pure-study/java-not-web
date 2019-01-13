package net.will.javatest.basicconcept.jdk8;

import java.util.Optional;

public class OptionalUsage {
    public static Optional<String> getOptionalValue(int input) {
        if (input > 0) {
            return Optional.of("positive");
        } else {
            return Optional.empty();
        }
    }
}
