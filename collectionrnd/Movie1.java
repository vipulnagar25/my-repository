package com.collectionrnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Movie1 implements Comparator {
    private double rating;
    private String name;
    private int year;
    // Constructor
    public Movie1(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
    @Override
    public int compare(Object o, Object t1) {
        Movie1 m1= (Movie1) o;
        Movie1 m2= (Movie1) t1;
        return m2.year-m1.year;
    }

    public static void main(String[] args) {
        ArrayList<Movie1> list = new ArrayList<>();
        list.add(new Movie1("Force Awakens", 8.3, 2015));
        list.add(new Movie1("Star Wars", 8.7, 1977));
        list.add(new Movie1("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie1("Return of the Jedi", 8.4, 1983));
        Collections.sort(list,new Movie1("Force Awakens", 8.3, 2015));
        for (Movie1 movie: list)
            System.out.println(movie.getRating() + " " +
                    movie.getName() + " " +
                    movie.getYear());

    }
}
