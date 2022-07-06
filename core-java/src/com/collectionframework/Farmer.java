package com.collectionframework;

import java.util.Objects;

public class Farmer {
    public int id;
    public String name;
    public String crop;


    public Farmer(int id, String name, String crop) {
        this.id = id;
        this.name = name;
        this.crop = crop;
    }

    public int getId() {
        return id;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    @Override
    public boolean equals(Object o) {
     //   System.out.println("I am from equal");
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Farmer farmer = (Farmer) o;

       // System.out.println();
        return id == farmer.id &&
                Objects.equals(name, farmer.name) &&
                Objects.equals(crop, farmer.crop);
    }

    @Override
    public int hashCode() {
        //System.out.println("I am from hashCode" + Objects.hash(id, name, crop));
        return Objects.hash(id, name, crop);
        //  return 1;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crop='" + crop + '\'' +
                '}';
    }
}
