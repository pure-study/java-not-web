package net.will.javatest.basicconcept.jdk8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import net.will.javatest.basicconcept.Person;

public class ConstructorMethodRefTest {
    private List<Person> roster = Collections.emptyList();
    
    @Before
    public void setup() {
        roster = new ArrayList<>();
        roster.add(new Person("person01"));
        roster.add(new Person("person02"));
    }
    
    @Test
    public void testLambdaExpression() {
        Set<Person> rosterSetLambda = ConstructorMethodRef.transferElements(roster, () -> {
            return new HashSet<>();
        });
        
        assertEquals(rosterSetLambda.size(), 2);
    }
    
    @Test
    public void testConstructorReference() {
        Set<Person> rosterSet = ConstructorMethodRef.transferElements(roster, HashSet::new);
        
        assertEquals(rosterSet.size(), 2);
    }
    
    @Test
    public void testConstructorReference_Alternative() {
        Set<Person> rosterSet = ConstructorMethodRef.transferElements(roster, HashSet<Person>::new);
        
        assertEquals(rosterSet.size(), 2);
    }
}
