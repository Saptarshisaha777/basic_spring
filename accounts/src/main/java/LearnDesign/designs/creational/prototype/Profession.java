package LearnDesign.designs.creational.prototype;

public abstract class Profession implements Cloneable {
    public int id;
    public String name;

    abstract void work();

    abstract void sleep();

    static void eat() {
        System.out.println("Eating");
    }


    public Profession cloningMethod() {
        try {
            return (Profession) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
