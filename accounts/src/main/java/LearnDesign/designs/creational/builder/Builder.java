package LearnDesign.designs.creational.builder;

public interface Builder {
    void buildFloor();
    void buildWall();
    void buildTerrace();
    Home getComplexHome();
}
