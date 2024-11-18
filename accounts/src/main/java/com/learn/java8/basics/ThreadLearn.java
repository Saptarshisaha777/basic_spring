package com.learn.java8.basics;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello, This is my thread ..."+Thread.currentThread().getName());
    }
}

class MyAnotherThread implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello, This is my another thread ..."+Thread.currentThread().getName());
    }
}

class Counter{
    int count = 0;
    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
public class ThreadLearn {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Hello,what is your name?");
       // String name = sc.nextLine();
       // System.out.println("Hi " + name + ", nice to meet you");

        MyThread myThread = new MyThread();
        MyAnotherThread myAnotherThread = new MyAnotherThread();
        myAnotherThread.run();
        myThread.start();
        myThread.join();
        System.out.println("Hello, This is main thread ..."+Thread.currentThread().getName());


        //Checking how synchronized works
        //Synchronized example
        //This example shows how if we are using the synchronized method or synchronized block
        //it will ensure that only one thread can access the method or block at any given time

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());

        //The below code snippet is a practice of synchronization using wait and notify method
        //the purpose of this code is to print the even numbers from 2 to 100 using two different threads
        //one thread will print the even numbers and the other thread will print the odd numbers
        //the use of lock (Object) is to share the same lock between two threads
        //we are using the wait method to make the thread wait until the lock is notified
        //the notify method is used to notify the waiting thread that the lock is free now
        AtomicBoolean isEven = new AtomicBoolean(false);
        Object lock = new Object();
        Thread evenThread = new Thread(() -> {
            for(int i=2;i<=100;i+=2) {
                synchronized (lock) {
                    while (!isEven.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Even Thread is running: " + i);
                    isEven.set(false);
                    lock.notifyAll();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for(int i=1;i<=100;i+=2) {
                synchronized (lock) {
                    while (isEven.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Odd Thread is running: " + i);
                    isEven.set(true);
                    lock.notifyAll();
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
