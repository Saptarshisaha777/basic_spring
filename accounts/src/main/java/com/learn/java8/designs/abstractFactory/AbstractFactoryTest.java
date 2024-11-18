package com.learn.java8.designs.abstractFactory;

import com.learn.java8.designs.abstractFactory.Doctor;
import com.learn.java8.designs.abstractFactory.Profession;
import com.learn.java8.designs.abstractFactory.ProfessionAbstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = AbstractFactoryProducer.getFactory("Trainee");
        Profession profession = abstractFactory.getProfession("Doctor");
        profession.work();
        profession.sleep();
    }
}
