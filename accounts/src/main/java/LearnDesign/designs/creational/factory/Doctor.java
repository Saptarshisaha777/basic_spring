package LearnDesign.designs.creational.factory;

public class Doctor implements Profession {
    @Override
    public void work() {
        System.out.println("Working as a doctor");
    }

    public static void eat() {
        System.out.println("Eating as the doctor");
    }

    public void sleep() {
        System.out.println("Sleeping as the doctor");
    }
}
