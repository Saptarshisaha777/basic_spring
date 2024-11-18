package com.learn.java8.basics;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "MyException{" +
                "message='" + super.getMessage() + '\'' +
                '}';
    }
}
public class ExceptionLearn {

    public static void main(String[] args) {
    try{
        throw new MyException(null);
    } catch (MyException e) {
        System.out.println(e);
    }

    }
}
