package LearnDesign.designs.creational.factory;

public class FactoryTest {
    public static void main(String[] args) {
        ProfessionFactory professionFactory = new ProfessionFactory();
        Profession profession = professionFactory.getProfession("Doctor");
        profession.work();
        profession.sleep();

        Doctor profession1 = new Doctor();
                profession1.eat();
    }
}
