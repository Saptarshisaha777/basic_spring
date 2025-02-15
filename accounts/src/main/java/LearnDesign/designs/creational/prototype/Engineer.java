package LearnDesign.designs.creational.prototype;

public class Engineer extends Profession {
    @Override
    public void work() {
        System.out.println("Working as an Engineer");
    }

    public static void eat() {
        System.out.println("Eating as the Engineer");
    }

    public void sleep() {
        System.out.println("Sleeping as the Engineer");
    }
}
