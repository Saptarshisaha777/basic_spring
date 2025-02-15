package LearnDesign.designs.creational.abstractFactory;

public class TraineeDoctor implements Profession {
    @Override
    public void work() {
        System.out.println("Working as a Trainee doctor");
    }

    public static void eat() {
        System.out.println("Eating as the Trainee doctor");
    }

    public void sleep() {
        System.out.println("Sleeping as the Trainee doctor");
    }
}
