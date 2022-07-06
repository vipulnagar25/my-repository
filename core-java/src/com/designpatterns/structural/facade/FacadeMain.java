package com.designpatterns.structural.facade;

public class FacadeMain {
    public static void main(String[] args) {
        ZooKeeper zookeeper = new ZooKeeper();
        zookeeper.feedLion();
        zookeeper.feedWolf();
        zookeeper.feedBear();
    }
}
