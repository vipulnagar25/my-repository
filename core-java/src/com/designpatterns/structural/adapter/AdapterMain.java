package com.designpatterns.structural.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        BuilderImplementation builderImpl = new BuilderImplementation();

        builderImpl.build("house", "Downtown");
        builderImpl.build("SkyScrapper", "City Center");
        builderImpl.build("SkyScrapper", "Outskirts");
        builderImpl.build("Hotel", "City Center");
    }
}
