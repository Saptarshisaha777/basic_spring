package LearnDesign.designs.creational.abstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = AbstractFactoryProducer.getFactory("Trainee");
        Profession profession = abstractFactory.getProfession("Doctor");
        profession.work();
        profession.sleep();
    }
}
