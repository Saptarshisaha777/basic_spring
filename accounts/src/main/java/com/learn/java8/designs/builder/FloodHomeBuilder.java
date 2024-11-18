package com.learn.java8.designs.builder;

public class FloodHomeBuilder implements Builder {
    private Home home = new Home();

    @Override
    public void buildFloor() {
        this.home.floor = "Flood proof floor";
    }

    @Override
    public void buildWall() {
        this.home.wall = "Flood proof wall";
    }

    @Override
    public void buildTerrace() {
        this.home.terrace = "Flood proof terrace";
    }

    @Override
    public Home getComplexHome() {
        return this.home;
    }

}
