package LearnDesign.designs.creational.builder;



public class BuilderTest {
    public static void main(String[] args) {
        EarthQuakeHomeBuilder earthQuakeHomeBuilder = new EarthQuakeHomeBuilder();
        Director director = new Director(earthQuakeHomeBuilder);
        director.manageHomeConstruction();
        Home home = director.getCompleteHome();
        System.out.println(home.floor);
        System.out.println(home.wall);
        System.out.println(home.terrace);

    }
}
