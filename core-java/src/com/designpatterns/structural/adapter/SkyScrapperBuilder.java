package com.designpatterns.structural.adapter;

public class SkyScrapperBuilder implements AdvancedBuilder {
    @Override
    public void buildHouse(String location) {

    }

    @Override
    public void buildSkyScrapper(String location) {
        System.out.println("Building a skyScrapper in the " + location + "area!");
    }
}
