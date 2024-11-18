package com.learn.java8.designs.abstractFactory;

import com.learn.java8.designs.abstractFactory.Profession;

public class Engineer implements Profession {
    @Override
    public void work() {
        System.out.println("Working as an Engineer");
    }

    public static void eat() {
        System.out.println("Eating as the Engineer");
    }

    public void sleep() {
        System.out.println("Sleeping as the Engineer");
    }
}
