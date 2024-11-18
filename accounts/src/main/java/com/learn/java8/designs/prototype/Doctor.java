package com.learn.java8.designs.prototype;

import com.learn.java8.designs.prototype.Profession;

public class Doctor extends Profession {
    @Override
    public void work() {
        System.out.println("Working as a doctor");
    }

    public static void eat() {
        System.out.println("Eating as the doctor");
    }

    public void sleep() {
        System.out.println("Sleeping as the doctor");
    }
}
