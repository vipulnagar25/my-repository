package com.designpatterns.structural.adapter;

public class HouseBuilder implements AdvancedBuilder {
    @Override
    public void buildHouse(String location) {
        System.out.println("Building a house located in the " + location + "area!");
    }

    @Override
    public void buildSkyScrapper(String location) {

    }
}
