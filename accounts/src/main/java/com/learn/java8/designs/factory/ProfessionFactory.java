package com.learn.java8.designs.factory;

public class ProfessionFactory {
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
