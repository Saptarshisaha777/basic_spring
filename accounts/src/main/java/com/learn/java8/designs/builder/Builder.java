package com.learn.java8.designs.builder;

public interface Builder {
    void buildFloor();
    void buildWall();
    void buildTerrace();
    Home getComplexHome();
}
