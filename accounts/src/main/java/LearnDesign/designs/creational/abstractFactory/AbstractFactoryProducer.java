package LearnDesign.designs.creational.abstractFactory;

public class AbstractFactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Trainee")) {
            return new TraineeProfessionAbstractFactory();
        } else if (choice.equalsIgnoreCase("Profession")) {
            return new ProfessionAbstractFactory();
        }
        return null;
    }
}
