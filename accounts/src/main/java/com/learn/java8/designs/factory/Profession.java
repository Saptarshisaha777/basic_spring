package com.learn.java8.designs.factory;

public interface Profession {
    abstract void work();

    default void sleep() {
        System.out.println("Sleeping");
    }

    static void eat() {
        System.out.println("Eating");
    }
}
