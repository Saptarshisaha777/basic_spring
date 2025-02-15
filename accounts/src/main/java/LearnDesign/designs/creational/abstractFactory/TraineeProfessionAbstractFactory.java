package LearnDesign.designs.creational.abstractFactory;

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
