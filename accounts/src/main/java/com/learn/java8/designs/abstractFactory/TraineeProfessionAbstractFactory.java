package com.learn.java8.designs.abstractFactory;

public class TraineeProfessionAbstractFactory implements AbstractFactory {
    private Profession profession;

    public Profession getProfession(String type) {
        if (type.equalsIgnoreCase("Engineer")) {
            profession =  new TraineeEngineer();
        } else if (type.equalsIgnoreCase("Doctor")) {
            profession = new TraineeDoctor();
        }
        return profession;
    }
}
