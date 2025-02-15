package LearnDesign.designs.creational.abstractFactory;

public class TraineeEngineer implements Profession {
    @Override
    public void work() {
        System.out.println("Working as an Trainee Engineer");
    }

    public static void eat() {
        System.out.println("Eating as the Trainee Engineer");
    }

    public void sleep() {
        System.out.println("Sleeping as the Trainee Engineer");
    }
}
