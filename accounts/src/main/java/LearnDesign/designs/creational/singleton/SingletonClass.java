package LearnDesign.designs.creational.singleton;

public class SingletonClass {
    private static SingletonClass instance = new SingletonClass();

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        return instance;
    }

    public static void print(){
        System.out.println("Hash code of the instance:: "+instance);
    }
}
