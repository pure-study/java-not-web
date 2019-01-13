package net.will.javatest.basicconcept.jdk8;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OptionalUsageTest {
    @Spy
    private Supplier<String> assistant = new SupplierAssistant();
    
    @Test
    public void testIsPresent() {
        Optional<String> value = OptionalUsage.getOptionalValue(10);
        assertTrue(value.isPresent());
        assertEquals("positive", value.get());
    }
    
    @Test
    public void testOrElse_WhenNotPresent() {
        Optional<String> value = OptionalUsage.getOptionalValue(-10);
        assertFalse(value.isPresent());
        assertEquals("new", value.orElse(createNewValue()));
    }
    
    @Test
    public void testOrElseGet_WhenNotPresent() {
        Optional<String> value = OptionalUsage.getOptionalValue(-10);
        String endValue = value.orElseGet(assistant);
        assertEquals("assistance", endValue);
        verify(assistant).get();
    }
    
    @Test
    public void testOrElseGet_WhenIsPresent_WithSupplier() {
        Optional<String> value = OptionalUsage.getOptionalValue(10);
        assertEquals("positive", value.orElseGet(assistant));
        verify(assistant, never()).get();
    }
    
    @Test
    public void testOrElseGet_WhenIsPresent_WithLambda() {
        Optional<String> value = OptionalUsage.getOptionalValue(10);
        assertEquals("positive", value.orElseGet(() -> createNewValue()));
    }
    
    private String createNewValue() {
        return "new";
    }
}
