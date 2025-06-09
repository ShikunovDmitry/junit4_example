package com.company;

import static  org.junit.Assert.assertEquals;

import com.company.core.Configuration;
import org.junit.Before;
import org.junit.Test;


//@Log4j
public class AnimalTest {
    @Before
    public void init(){
        Configuration.getProperties();
        System.out.println("Password " + Configuration.getProperties().get("password").toString().replace("w", "x"));
        System.out.println("Running in browser " + Configuration.getProperties().get("browser"));
        System.out.println("Running on environment " + Configuration.getProperties().get("env"));
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("env"));
    }

    @Test
    public void testDog() {
        Animal dog = new Dog();
        assertEquals("Dog", dog.whoIam());
    }

    @Test
    public void testCat() {
        Animal cat = new Cat();
        assertEquals("Cat", cat.whoIam());
    }

    @Test
    public void testPig() {
        Animal pig = new Pig();
        assertEquals("Pig", pig.whoIam());
    }
}
