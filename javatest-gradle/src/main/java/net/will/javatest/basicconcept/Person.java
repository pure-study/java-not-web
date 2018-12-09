package net.will.javatest.basicconcept;

import java.time.LocalDate;

public class Person {
    
    public enum Sex {
        MALE, FEMALE
    }
    
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;
    
    public Person(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
}
