package LearnDesign.designs.creational.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Home getCompleteHome() {
        return this.builder.getComplexHome();
    }

    public void manageHomeConstruction() {
        this.builder.buildFloor();
        this.builder.buildWall();
        this.builder.buildTerrace();
    }
}
