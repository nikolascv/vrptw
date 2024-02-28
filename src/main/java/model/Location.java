package main.java.model;

import java.util.Random;

public class Location {
    private double xCoordinate;
    private double yCoordinate;
    // private int node;

    public Location(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        // this.node = node;
    }

    public double getxCoordinate() {
        return this.xCoordinate;
    }

    public double getyCoordinate() {
        return this.yCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    // public int getNode() {
    //     return this.node;
    // }

    // public void setNode(int node) {
    //     this.node = node;
    // }

    public static Location generateRandomLocation(double minX, double maxX, double minY, double maxY) {
        Random random = new Random();
        double randomX = minX + (maxX - minX) * random.nextDouble();
        double randomY = minY + (maxY - minY) * random.nextDouble();
        return new Location(randomX, randomY);
    }
}
