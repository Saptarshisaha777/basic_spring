package LearnDesign.designs.creational.abstractFactory;

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
