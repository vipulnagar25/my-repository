package com.designpatterns.structural.adapter;

public class BuilderAdapter implements Builder {
    AdvancedBuilder advancedBuilder;

    public BuilderAdapter(String type) {
        if(type.equalsIgnoreCase("House")) {
            advancedBuilder = new HouseBuilder();
        } else if(type.equalsIgnoreCase("Skyscrapper")) {
            advancedBuilder = new SkyScrapperBuilder();
        }
    }

    @Override
    public void build(String type, String location) {
        if(type.equalsIgnoreCase("House")) {
            advancedBuilder.buildHouse(location);
        } else if(type.equalsIgnoreCase("Skyscrapper")) {
            advancedBuilder.buildSkyScrapper(location);
        }
    }
}
