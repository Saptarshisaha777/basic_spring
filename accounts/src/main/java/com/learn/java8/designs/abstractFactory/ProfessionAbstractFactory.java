package com.learn.java8.designs.abstractFactory;

import com.learn.java8.designs.abstractFactory.Doctor;
import com.learn.java8.designs.abstractFactory.Engineer;
import com.learn.java8.designs.abstractFactory.Profession;

public class ProfessionAbstractFactory implements AbstractFactory {
    private Profession profession;

    public Profession getProfession(String type) {
        if (type.equalsIgnoreCase("Engineer")) {
            profession = new Engineer();
        } else if (type.equalsIgnoreCase("Doctor")) {
            profession = new Doctor();
        }
        return profession;
    }
}
