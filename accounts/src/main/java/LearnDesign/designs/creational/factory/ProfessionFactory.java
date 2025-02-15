package LearnDesign.designs.creational.factory;

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
