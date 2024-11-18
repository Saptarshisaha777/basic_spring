package com.learn.java8.designs.builder;

public class EarthQuakeHomeBuilder implements Builder {
    private Home home = new Home();

    @Override
    public void buildFloor() {
        this.home.floor = "EarthQuake proof floor";
    }

    @Override
    public void buildWall() {
        this.home.wall = "EarthQuake proof wall";
    }

    @Override
    public void buildTerrace() {
        this.home.terrace = "EarthQuake proof terrace";
    }

    @Override
    public Home getComplexHome() {
        return this.home;
    }

}
