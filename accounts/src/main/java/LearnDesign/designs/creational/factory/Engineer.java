package LearnDesign.designs.creational.factory;

public class Engineer implements Profession {
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
