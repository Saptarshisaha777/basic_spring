package LearnDesign.designs.creational.prototype;

public class Doctor extends Profession {
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
