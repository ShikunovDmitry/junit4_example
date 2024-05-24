package com.company;

import com.company.Animal;
import com.company.Cat;
import com.company.Dog;
import com.company.Pig;
import static  org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class AnimalTest {
    @Before
    public void init(){
        System.out.println("Running in browser " + System.getProperty("browser"));
        System.out.println("Running on environment " + System.getProperty("env"));
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
