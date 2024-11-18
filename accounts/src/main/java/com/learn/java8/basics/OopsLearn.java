package com.learn.java8.basics;

import java.util.Optional;

class Parent {
    public void hello(){
        System.out.println("Hi, This is the parent.");
    }

    //method overloading
    public void hello(String name){
        System.out.println("Hi "+name+", This is the parent.");
    }

    // Static methods cannot be overridden in Java. They are bound to the class,
    // not the instance of the class. If a subclass defines a static method with
    // the same signature as a static method in the superclass, this is called
    // method hiding, not overriding. The version of the method that gets called
    // is determined by the class type, not the object type.

    public static void display(){
        System.out.println("Displaying the parent");
    }

    //final cannot be overriden
    public final void run(){
        System.out.println("Running the parent");
    }

    //scope change
    private void eat(){
        System.out.println("Eating with the parent");
    }

    public void accessEat(){
        eat();
    }

}

class Child extends Parent {

    @Override
    public void hello(){
        System.out.println("Hi, This is the Child.");
    }

    //method hiding
    public static void display(){
        System.out.println("Displaying the child.");
    }


    public void eat(){
        System.out.println("Eating with the child");
    }

}

public class OopsLearn {
    public static void main(String[] args){

        //method overloading
        Parent p = new Parent();
        p.hello();
        p.hello("Saha");

        //method overriding
        Parent c = new Child();
        c.hello();

        //Inheritance
        c.hello("Sapta");

        //method hiding
        p.display();
        c.display();

        Child c2 = new Child();
        c2.display();

        //final cannot be overriden
        c.run();
        c2.run();

        //scope change
        p.accessEat();
        c2.accessEat(); //this access the private eat() class of Parent instead of the child

        //Optional
        Optional<String> name = Optional.ofNullable("null");
        System.out.println(name.orElseThrow(ArithmeticException::new));



    }
}
