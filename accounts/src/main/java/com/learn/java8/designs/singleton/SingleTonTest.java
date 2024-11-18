package com.learn.java8.designs.singleton;

public class SingleTonTest {
    public static void main(String[] args) {
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        singletonClass1.print();

        SingletonClass singletonClass2 = SingletonClass.getInstance();
        singletonClass2.print();

        System.out.println(singletonClass1 == singletonClass2);
    }
}
